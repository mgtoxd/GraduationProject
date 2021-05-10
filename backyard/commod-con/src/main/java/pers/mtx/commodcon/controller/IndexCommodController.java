package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.CommodBasedinfo;
import pers.mtx.commodcon.entity.CommodImg;
import pers.mtx.commodcon.entity.CommodTripInfo;
import pers.mtx.commodcon.entity.CommodTxt;
import pers.mtx.commodcon.feign.*;
import pers.mtx.commodcon.result.RestResponse;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 19:55
 **/
@RestController
@RequestMapping("/IndexCommod")
public class IndexCommodController {
    @Autowired
    ClassifyFeign classifyFeign;

    @Autowired
    CommodBasedinfoControllerFeign basedinfoControllerFeign;
    @Autowired
    CommodFeign commodFeign;
    @Autowired
    TripFeign tripFeign;
    @Autowired
    CommodTxtControllerFeign commodTxtControllerFeign;


    @GetMapping("/GetCommodDetailById")
    public RestResponse GetCommodDetailById(@RequestParam("commodId") String commodId){
        CommodBasedinfo basedinfo = basedinfoControllerFeign.getByid(commodId);
        List<CommodImg> contentImgs = commodFeign.getContentImgByCommodId(commodId);
        List<CommodTripInfo> commodTripInfos = tripFeign.listCommodTripInfoByCommodId(commodId);
        CommodTxt txt = commodTxtControllerFeign.getByid(commodId);
        HashMap<String, Object> map = new HashMap<>();

        map.put("baseInfo",basedinfo);
        map.put("contentImgs",contentImgs);
        map.put("commodTripInfos",commodTripInfos);
        map.put("txt",txt);
        return RestResponse.success(map);
    }


}
