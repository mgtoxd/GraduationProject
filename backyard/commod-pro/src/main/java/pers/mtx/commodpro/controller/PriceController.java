package pers.mtx.commodpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodpro.ab.entity.CommodPriceDate;
import pers.mtx.commodpro.ab.service.ICommodPriceDateService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 8:52
 **/
@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    ICommodPriceDateService commodPriceDateService;

    /**
    * @Author: 马韬循
    * @Description: 根据商品id获取特殊日期价格
    * @DateTime: 8:56 2021/4/30
    * @Params: 
    * @Return 
    **/
    @GetMapping("/listDatePriceByCommodId")
    public List<CommodPriceDate> listDatePriceByCommodId(@RequestParam("id") String id){
        return commodPriceDateService.list(new QueryWrapper<CommodPriceDate>().eq("commod_id",id));
    }

    /**
    * @Author: 马韬循
    * @Description: 根据商品id删除特殊日期价格
    * @DateTime: 9:11 2021/4/30
    * @Params: 
    * @Return 
    **/
    @GetMapping("/removeDatePriceByCommodId")
    public Boolean removeDatePriceByCommodId(@RequestParam("id") String id){
        return commodPriceDateService.remove(new QueryWrapper<CommodPriceDate>().eq("commod_id",id));
    }
}
