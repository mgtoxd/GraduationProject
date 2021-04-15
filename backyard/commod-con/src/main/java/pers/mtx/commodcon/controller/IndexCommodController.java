package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodcon.feign.ClassifyFeign;
import pers.mtx.commodcon.result.RestResponse;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 19:55
 **/
@RestController
public class IndexCommodController {
    @Autowired
    ClassifyFeign classifyFeign;
//    @GetMapping("/getCommodsByClassify")
//    public RestResponse getCommodsByClassify(@RequestParam("id") String classifyId){
//
//    }
}
