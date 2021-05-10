package pers.mtx.commodpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodpro.ab.entity.CommodTripInfo;
import pers.mtx.commodpro.ab.service.ICommodTripInfoService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 13:22
 **/
@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    ICommodTripInfoService tripInfoService;
    @Autowired
    ICommodTripInfoService commodTripInfoService;
    @GetMapping("/removeByCommodId")
    public Boolean removeByCommodId(@RequestParam("id") String id){
        return tripInfoService.remove(new QueryWrapper<CommodTripInfo>().eq("commod_id", id));
    }

    @PostMapping(value = "/listByCommodId")
    public List<CommodTripInfo> listCommodTripInfoByCommodId(@RequestBody String id) {
        return commodTripInfoService.list(new QueryWrapper<CommodTripInfo>().eq("commod_id",id).orderByAsc("commod_trip_sort"));
    }
}
