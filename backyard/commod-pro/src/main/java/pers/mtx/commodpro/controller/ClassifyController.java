package pers.mtx.commodpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodpro.ab.entity.ClassifyInfo;
import pers.mtx.commodpro.ab.entity.CommodClassify;
import pers.mtx.commodpro.ab.service.IClassifyInfoService;
import pers.mtx.commodpro.ab.service.ICommodClassifyService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/29 8:49
 **/
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    ICommodClassifyService commodClassifyService;

    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取其分类列表
    * @DateTime: 8:50 2021/4/29
    * @Params:
    * @Return
    **/
    @GetMapping("/listByCommodId")
    public List<CommodClassify> listByCommodId(@RequestParam("id") String id){
        return commodClassifyService.list(new QueryWrapper<CommodClassify>().eq("commod_id", id));
    }
    
    /**
    * @Author: 马韬循
    * @Description: 通过commodId删除classify
    * @DateTime: 9:51 2021/4/29
    * @Params: 
    * @Return 
    **/
    @GetMapping("/removeByCommodId")
    public Boolean removeByCommodId(@RequestParam("id") String id){
        return commodClassifyService.remove(new QueryWrapper<CommodClassify>().eq("commod_id", id));
    }
}
