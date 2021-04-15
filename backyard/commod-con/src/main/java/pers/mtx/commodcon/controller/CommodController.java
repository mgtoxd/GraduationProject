package pers.mtx.commodcon.controller;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.CommodBasedinfo;
import pers.mtx.commodcon.entity.CommodPrice;
import pers.mtx.commodcon.entity.CommodStore;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.SetCommod;

import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 20:45
 **/
@RestController
@RequestMapping("/Commod")
public class CommodController {
    @RequestMapping("/setCommod")
    public RestResponse setCommod(@RequestBody SetCommod commod){
        Mapper mapper = new DozerBeanMapper();
        commod.setCommodId(UUID.randomUUID().toString());
        CommodBasedinfo basedinfo = mapper.map(commod, CommodBasedinfo.class);
        CommodPrice price = mapper.map(commod, CommodPrice.class);
        CommodStore store = mapper.map(commod, CommodStore.class);
        System.out.println(basedinfo);
        System.out.println(price);
        System.out.println(store);
        return RestResponse.success();
    }
}
