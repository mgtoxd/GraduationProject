package pers.mtx.market_con.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.market_con.entity.CommodBasedinfo;
import pers.mtx.market_con.entity.SpecColumn;
import pers.mtx.market_con.entity.SpecColumnCommod;
import pers.mtx.market_con.feign.CommodFeign;
import pers.mtx.market_con.feign.MarketSpecColumnFeign;
import pers.mtx.market_con.result.RestResponse;
import pers.mtx.market_con.vo.IndexSpeCommodVVo;
import pers.mtx.market_con.vo.IndexSpecialColumnVo;
import pers.mtx.market_con.vo.SpecialColumnCommodVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/3 16:24
 **/
@RestController
@RequestMapping("/SpecialColumn")
public class SpecialColumnController {
    @Autowired
    Mapper dozerMapper;
    @Autowired
    MarketSpecColumnFeign specColumnFeign;
    @Autowired
    CommodFeign commodFeign;
    /**
    * @Author: 马韬循
    * @Description: 获取所有专栏信息
    * @DateTime: 16:25 2021/5/3
    * @Params:
    * @Return
    **/
    @GetMapping("/listSpecColumn")
    public RestResponse listSpecColumn(){
        return RestResponse.success(specColumnFeign.pageSpecColumn(1,1000));
    }


    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取商品的专栏信息
    * @DateTime: 16:27 2021/5/3
    * @Params:
    * @Return
    **/
    @GetMapping("/listSpecColumnCommodBycommodId")
    public RestResponse listSpecColumnCommodBycommodId(@RequestParam("id") String commodId){
        return RestResponse.success(specColumnFeign.listSpecColumnCommodBycommodId(commodId));
    }

    /**
    * @Author: 马韬循
    * @Description: 添加或修改商品专栏信息
    * @DateTime: 16:30 2021/5/3
    * @Params:
    * @Return
    **/
    @PostMapping("/addOrUpdateSpecColumnCommodList")
    public RestResponse addOrUpdateSpecColumnCommodList(@RequestBody List<SpecColumnCommod> specColumnCommodList){
        return specColumnFeign.addOrUpdateList(specColumnCommodList)?RestResponse.success():RestResponse.error();
    }


    /**
    * @Author: 马韬循
    * @Description: 添加新专栏
    * @DateTime: 17:04 2021/5/3
    * @Params: 
    * @Return 
    **/
    @PostMapping("/addSpecialColumn")
    public RestResponse addSpecialColumn(@RequestBody SpecColumn specColumn){
        specColumnFeign.addSpecColumn(specColumn);
        return RestResponse.success();
    }


    /**
    * @Author: 马韬循
    * @Description: 通过专栏id获取专栏下的商品信息
    * @DateTime: 18:27 2021/5/3
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getCommodsBySpecColumnId")
    public RestResponse getCommodsBySpecColumnId(@RequestParam("id") String specColumnId){
        ArrayList<SpecialColumnCommodVo> result = new ArrayList<>();
        List<SpecColumnCommod> specColumnCommods = specColumnFeign.listBySpecColumnId(specColumnId);
        for (SpecColumnCommod item :
                specColumnCommods) {
            CommodBasedinfo basedinfoByid = commodFeign.getCommodBasedinfoByid(item.getCommodId());
            SpecialColumnCommodVo vo = dozerMapper.map(basedinfoByid, SpecialColumnCommodVo.class);
            vo.setSpecColumnCommodId(item.getSpecColumnCommodId());
            result.add(vo);
        }
        return RestResponse.success(result);
    }

    /**
    * @Author: 马韬循
    * @Description: 通过id删除商品和专栏关联
    * @DateTime: 20:11 2021/5/3
    * @Params: 
    * @Return 
    **/
    @GetMapping("/removeSpecialColumnCommodById")
    public RestResponse removeSpecialColumnCommodById(@RequestParam("id") String id){
        return specColumnFeign.removeSpecColumnCommodById(id)?RestResponse.success():RestResponse.error();
    }
    
    /**
    * @Author: 马韬循
    * @Description: 获取首页专栏信息
    * @DateTime: 20:16 2021/5/3
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getIndexSpecialColumn")
    public RestResponse getIndexSpecialColumn(){
        List<SpecColumn> specColumns = specColumnFeign.pageSpecColumn(1, 1000);
        ArrayList<IndexSpecialColumnVo> result = new ArrayList<>();
        for (SpecColumn item :
                specColumns) {
            IndexSpecialColumnVo specialColumnVo = dozerMapper.map(item, IndexSpecialColumnVo.class);
            List<SpecColumnCommod> specColumnCommods = specColumnFeign.listBySpecColumnId(item.getSpecColumnId());
            ArrayList<IndexSpeCommodVVo> indexSpeCommodVVos = new ArrayList<>();
            for (SpecColumnCommod itemspCommod :
                    specColumnCommods) {
                CommodBasedinfo basedinfo = commodFeign.getCommodBasedinfoByid(itemspCommod.getCommodId());
                if (basedinfo==null){
                    continue;
                }
                IndexSpeCommodVVo speCommodVVo = new IndexSpeCommodVVo();
                dozerMapper.map(basedinfo, speCommodVVo);
                speCommodVVo.setSpecColumnCommodImgUrl(itemspCommod.getSpecColumnCommodImgUrl());
                indexSpeCommodVVos.add(speCommodVVo);
            }
            specialColumnVo.setItems(indexSpeCommodVVos);
            result.add(specialColumnVo);
        }
        return RestResponse.success(result);
    }
}
