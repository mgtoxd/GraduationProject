package pers.mtx.commodpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodpro.ab.service.ICommodBasedinfoService;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/28 17:25
 **/
@RestController
@RequestMapping("/count")
public class CountController {
    @Autowired
    ICommodBasedinfoService commodBasedinfoService;

    @GetMapping("/CommodBasedinfo")
    public Integer CommodBasedinfo(){
        return commodBasedinfoService.count();
    }
}
