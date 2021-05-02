package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.CommodTripInfo;
import pers.mtx.commodcon.feign.TripFeign;
import pers.mtx.commodcon.result.RestResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 13:09
 **/
@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TripFeign tripFeign;
    
    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取行程信息
    * @DateTime: 13:10 2021/4/30
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getTripInfoByCommodId")
    public RestResponse getTripInfoByCommodId(@RequestParam("id") String id){
        List<CommodTripInfo> commodTripInfos = tripFeign.listCommodTripInfoByCommodId(id);
        return RestResponse.success(commodTripInfos);
    }

    /**
    * @Author: 马韬循
    * @Description: 通过商品id设置行程
    * @DateTime: 13:54 2021/4/30
    * @Params: 
    * @Return 
    **/
    @PostMapping("/setTripInfoByCommodId")
    public RestResponse setTripInfoByCommodId(@RequestBody List<CommodTripInfo> tripInfos){
        tripFeign.removeByCommodId(tripInfos.get(0).getCommodId());
        return tripFeign.addCommodTripInfoList(tripInfos)?RestResponse.success():RestResponse.error();
    }
}
