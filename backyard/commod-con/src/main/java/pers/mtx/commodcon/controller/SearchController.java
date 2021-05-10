package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodcon.entity.CommodBasedinfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.entity.CommodPrice;
import pers.mtx.commodcon.feign.ClassifyFeign;
import pers.mtx.commodcon.feign.CommodBasedinfoControllerFeign;
import pers.mtx.commodcon.feign.CommodPriceControllerFeign;
import pers.mtx.commodcon.result.RestResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/6 20:30
 **/
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    ClassifyFeign classifyFeign;

    @Autowired
    IndexCommodController indexCommodController;

    @Autowired
    CommodBasedinfoControllerFeign commodBasedinfoControllerFeign;
    @Autowired
    CommodPriceControllerFeign commodPriceControllerFeign;

    @GetMapping("/listByClassify")
    public RestResponse listByClassify(@RequestParam("id") String classifyId){
        ArrayList<Object> result = new ArrayList<>();
        List<CommodClassify> classifyList = classifyFeign.listCommodIdByClassifyId(classifyId);
        for (CommodClassify item :
                classifyList) {
            HashMap<String, Object> map = new HashMap<>();
            CommodBasedinfo byid = commodBasedinfoControllerFeign.getByid(item.getCommodId());
            if (byid!=null){
                CommodPrice price = commodPriceControllerFeign.getByid(item.getCommodId());
                map.put("baseInfo",byid);
                map.put("price",price);
                result.add(map);
            }
        }
        return RestResponse.success(result);
    }

    @GetMapping("/searchByName")
    public RestResponse searchByName(@RequestParam("name") String name){
        ArrayList<Object> result = new ArrayList<>();
        List<CommodBasedinfo> commodBasedinfos = classifyFeign.listCommodIdByNameLike(name);
        for (CommodBasedinfo item :
                commodBasedinfos) {
            HashMap<String, Object> map = new HashMap<>();
            CommodBasedinfo byid = commodBasedinfoControllerFeign.getByid(item.getCommodId());
            if (byid!=null){
                CommodPrice price = commodPriceControllerFeign.getByid(item.getCommodId());
                map.put("baseInfo",byid);
                map.put("price",price);
                result.add(map);
            }
        }
        return RestResponse.success(result);
    }
}
