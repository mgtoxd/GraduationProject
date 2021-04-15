package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.feign.ClassifyFeign;
import pers.mtx.commodcon.result.RestResponse;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 20:12
 **/
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    ClassifyFeign classifyFeign;
    @PostMapping("/add")
    public RestResponse add(@RequestBody ClassifyInfo info){
        return RestResponse.success(classifyFeign.add(info));
    }
}
