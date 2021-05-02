package pers.mtx.commodcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.CommodSku;
import pers.mtx.commodcon.feign.SkuFeign;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.SetSkuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description: 库存控制器
 * @DateTime: 2021/4/30 11:01
 **/
@RestController
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    SkuFeign skuFeign;

    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取所有库存信息
    * @DateTime: 11:15 2021/4/30
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getSkuInfoByCommodId")
    public RestResponse getSkuInfoByCommodId(@RequestParam("id") String id){
        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        List<CommodSku> commodSkus = skuFeign.listCommodSkuByIdList(list);
        return RestResponse.success(commodSkus);
    }


    @PostMapping("/setSkuInfo")
    public RestResponse setSkuInfo(@RequestBody SetSkuVo skuVo){
        skuFeign.removeCommodSkuById(skuVo.getId());
        return skuFeign.addCommodSkuList(skuVo.getSkuList())?RestResponse.success():RestResponse.error();
    }
}
