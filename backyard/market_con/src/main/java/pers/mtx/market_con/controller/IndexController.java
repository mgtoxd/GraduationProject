package pers.mtx.market_con.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.market_con.entity.IndexShowCommod;
import pers.mtx.market_con.feign.MarketFeign;
import pers.mtx.market_con.result.RestResponse;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 16:19
 **/
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    MarketFeign marketFeign;
    /**
    * @Author: 马韬循
    * @Description: 获取首页位置信息
    * @DateTime: 9:18 2021/5/2
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getIndexList")
    public RestResponse getIndexList(){
        List<IndexShowCommod> page = marketFeign.page(1, 1000);
        return RestResponse.success(page);
    }

    /**
    * @Author: 马韬循
    * @Description: 通过商品id获取首页位置信息
    * @DateTime: 9:18 2021/5/2
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getIndexInfoByCommodId")
    public RestResponse getIndexInfoByCommodId(@RequestParam("id") String id){
        return RestResponse.success(marketFeign.listindexinfoByCommodId(id));
    }

    /**
    * @Author: 马韬循
    * @Description: 获取首页位置信息列表
    * @DateTime: 9:22 2021/5/2
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getIndexPosList")
    public RestResponse getIndexPosList(){
        return RestResponse.success(marketFeign.pageIndexPos(1, 1000));
    }


    /**
    * @Author: 马韬循
    * @Description: 添加商品到首页
    * @DateTime: 9:26 2021/5/2
    * @Params: 
    * @Return 
    **/
    @PostMapping("/addIndexInfo")
    public RestResponse addIndexInfo(@RequestBody List<IndexShowCommod> indexShowCommods){
        return marketFeign.addOrUpdateIndexShowCommodList(indexShowCommods)?RestResponse.success():RestResponse.error();
    }

}
