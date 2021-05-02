package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.feign.ClassifyFeign;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.setClassifyVo;

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
    public RestResponse add(@RequestBody ClassifyInfo info) {

        return RestResponse.success(classifyFeign.add(info));
    }

    @GetMapping("/page")
    public RestResponse page(@RequestParam("count") Integer count, @RequestParam("size") Integer size) {
        return RestResponse.success(classifyFeign.pageClassifyInfo(count, size));
    }

    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取分类列表
    * @DateTime: 9:51 2021/4/29
    * @Params: 
    * @Return 
    **/
    @GetMapping("/listClassifyById")
    public RestResponse listClassifyById(@RequestParam("id") String id) {
        return RestResponse.success(classifyFeign.listByCommodId(id));
    }

    /**
    * @Author: 马韬循
    * @Description: 通过商品id改变其分类信息
    * @DateTime: 9:52 2021/4/29
    * @Params: 
    * @Return 
    **/
    @PostMapping("/changeClassifyByCommodId")
    public RestResponse changeClassifyByCommodId(@RequestBody setClassifyVo classifyVo) {
        classifyFeign.removeByCommodId(classifyVo.getCommodId());
        for (String classifyId : classifyVo.getClassifyIds()
        ) {
            CommodClassify classify = new CommodClassify().setCommodId(classifyVo.getCommodId()).setClassifyId(classifyId);
            classifyFeign.addCommodClassify(classify);
        }
        return RestResponse.success(true);
    }

}
