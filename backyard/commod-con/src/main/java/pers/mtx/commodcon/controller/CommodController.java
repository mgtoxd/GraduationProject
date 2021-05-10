package pers.mtx.commodcon.controller;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.*;
import pers.mtx.commodcon.feign.CommodClassifyControllerFeign;
import pers.mtx.commodcon.feign.CommodFeign;
import pers.mtx.commodcon.feign.MarketCFeign;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.SetCommod;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 20:45
 **/
@RestController
@RequestMapping("/Commod")
public class CommodController {
    @Autowired
    Mapper dozerMapper;
    @Autowired
    CommodFeign commodFeign;
    @Autowired
    MarketCFeign marketCFeign;
    @Autowired
    CommodClassifyControllerFeign commodClassifyControllerFeign;

    /**
     * @Author: 马韬循
     * @Description: 新建商品
     * @DateTime: 12:24 2021/4/27
     * @Params:
     * @Return
     **/
    @RequestMapping("/setCommod")
    public RestResponse setCommod(@RequestBody SetCommod commod) {
        commod.setCommodId(UUID.randomUUID().toString());
        CommodBasedinfo basedinfo = dozerMapper.map(commod, CommodBasedinfo.class);
        CommodPrice price = dozerMapper.map(commod, CommodPrice.class);
        CommodTxt txt = dozerMapper.map(commod, CommodTxt.class);
        commodFeign.addCommodSku(dozerMapper.map(commod, CommodSku.class));
        commodFeign.addCommodBasedinfo(basedinfo);
        commodFeign.addCommodPrice(price);
        commodFeign.addCommodTxt(txt);
        CommodImg commodImgIndex = new CommodImg().setCommodId(commod.getCommodId()).setUrl(commod.getCommodIndexImg()).setIsIndex(true);
        commodFeign.addCommodImg(commodImgIndex);

        for (String classifyId : commod.getClassifyIds()
        ) {
            commodFeign.addCommodClassify(new CommodClassify().setCommodId(commod.getCommodId()).setClassifyId(classifyId));
        }

        for (int i = 0; i < commod.getTrips().size(); i++) {
            commod.getTrips().get(i).setCommodId(commod.getCommodId());
        }
        commodFeign.addListCommodTripInfo(commod.getTrips());
        for (String url : commod.getCaroulurls()
        ) {
            CommodImg commodImg = new CommodImg();
            commodImg.setCommodId(commod.getCommodId()).setIsContent(true).setUrl(url);
            commodFeign.addCommodImg(commodImg);
        }

        return RestResponse.success();
    }


    /**
    * @Author: 马韬循
    * @Description: 获取基础信息列表
    * @DateTime: 17:24 2021/4/28
    * @Params: 
    * @Return 
    **/
    @RequestMapping("/pageBase")
    public RestResponse pageBase(@RequestParam("count") Integer count, @RequestParam("size") Integer size){
        List<CommodBasedinfo> commodBasedinfos = commodFeign.pageCommodBasedinfo(count, size);
        HashMap<String, Object> result = new HashMap<>();
        result.put("list",commodBasedinfos);
        result.put("pageNum",commodFeign.CountCommodBasedinfo()/size);
        return RestResponse.success(result);
    }

    @GetMapping("/removeCommodByCommodId")
    public RestResponse removeCommod(@RequestParam("id") String id){
        marketCFeign.removeIndexInfoByCommodId(id);
        return commodFeign.removeCommodBaseinfoById(id)?RestResponse.success():RestResponse.error();
    }
}
