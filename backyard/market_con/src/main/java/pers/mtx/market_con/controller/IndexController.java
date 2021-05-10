package pers.mtx.market_con.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.market_con.entity.CommodBasedinfo;
import pers.mtx.market_con.entity.IndexShowCommod;
import pers.mtx.market_con.feign.CommodFeign;
import pers.mtx.market_con.feign.MarketFeign;
import pers.mtx.market_con.result.RestResponse;
import pers.mtx.market_con.vo.IndexCommodPosVo;

import java.util.ArrayList;
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
    Mapper dozerMapper;
    @Autowired
    MarketFeign marketFeign;
    @Autowired
    CommodFeign commodFeign;
    /**
    * @Author: 马韬循
    * @Description: 获取首页位置信息
    * @DateTime: 9:18 2021/5/2
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getIndexList")
    public RestResponse getIndexList(){
        ArrayList<IndexCommodPosVo> result = new ArrayList<>();
        List<IndexShowCommod> page = marketFeign.page(1, 1000);
        for (IndexShowCommod indexShowCommod   : page) {
            IndexCommodPosVo indexCommodPosVo = dozerMapper.map(indexShowCommod,IndexCommodPosVo.class);
            indexCommodPosVo.setPosName(marketFeign.getIndexPosByid(indexShowCommod.getComPos()).getPosName());
            CommodBasedinfo basedinfo = commodFeign.getCommodBasedinfoByid(indexShowCommod.getCommodId());
            indexCommodPosVo.setCommodName(basedinfo.getCommodName());
            result.add(indexCommodPosVo);
        }
        return RestResponse.success(result);
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
    * @Description: 通过商品id删除首页信息
    * @DateTime: 13:27 2021/5/3
    * @Params: 
    * @Return 
    **/
    @GetMapping("/removeIndexInfoByCommodId")
    public RestResponse removeIndexInfoByCommodId(@RequestParam("id") String id){
        marketFeign.removeIndexShowCommodByCommodId(id);
        return RestResponse.success();
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

    /**
    * @Author: 马韬循
    * @Description: 通过indexShowCommodId删除首页信息
    * @DateTime: 13:39 2021/5/2
    * @Params: 
    * @Return 
    **/
    @GetMapping("/removeInfoByindexShowCommodId")
    public RestResponse removeInfoByindexShowCommodId(@RequestParam("id") String id ){
        return marketFeign.removeIndexShowCommodById(id)?RestResponse.success():RestResponse.error();
    }


    /**
    * @Author: 马韬循
    * @Description: 更新首页商品信息单个
    * @DateTime: 17:15 2021/5/2
    * @Params: 
    * @Return 
    **/
    @PostMapping("/updateIndexShowCommod")
    public RestResponse updateIndexShowCommod(@RequestBody IndexShowCommod indexShowCommod){
        return marketFeign.updateIndexShowCommodById(indexShowCommod)?RestResponse.success(): RestResponse.error();
    }

}
