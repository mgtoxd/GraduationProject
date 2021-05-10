package pers.mtx.market_con.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.market_con.entity.CommodBasedinfo;
import pers.mtx.market_con.entity.SecCommod;
import pers.mtx.market_con.entity.SecKill;
import pers.mtx.market_con.feign.CommodFeign;
import pers.mtx.market_con.feign.MarketFeign;
import pers.mtx.market_con.result.RestResponse;
import pers.mtx.market_con.vo.SecKillCommodVo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/2 17:15
 **/
@RestController
@RequestMapping("/SecK")
public class SecKillController {
    @Autowired
    MarketFeign marketFeign;
    @Autowired
    CommodFeign commodFeign;
    @Autowired
    Mapper dozerMapper;

    /**
    * @Author: 马韬循
    * @Description: 修改或添加秒杀商品
    * @DateTime: 17:26 2021/5/2
    * @Params:
    * @Return
    **/
    @PostMapping("/addOrUpdateSecCommod")
    public RestResponse addOrUpdateSecCommod(@RequestBody SecCommod secCommod){
        return marketFeign.addOrUpdateSecKillCommod(secCommod) ? RestResponse.success() : RestResponse.error();
    }


    /**
    * @Author: 马韬循
    * @Description: 获取商品的秒杀活动情况
    * @DateTime: 17:38 2021/5/2
    * @Params:
    * @Return
    **/
    @GetMapping("/getSecByCommodId")
    public RestResponse getSecByCommodId(@RequestParam("id") String id){
        SecCommod secCommod = marketFeign.getSecKByCommodId(id);
//        if (secCommod!=null){
//            return RestResponse.success(marketFeign.getSecKillByid(secCommod.getSecId()));
//        }
        return secCommod!=null?RestResponse.success(secCommod):RestResponse.error();
    }

    /**
    * @Author: 马韬循
    * @Description: 获取秒杀活动列表
    * @DateTime: 17:38 2021/5/2
    * @Params:
    * @Return
    **/
    @GetMapping("/listSecKill")
    public RestResponse listSecKill(){
        return RestResponse.success(marketFeign.pageSecKill(1, 1000));
    }
    
    /**
    * @Author: 马韬循
    * @Description: 添加秒杀活动
    * @DateTime: 18:29 2021/5/2
    * @Params: 
    * @Return 
    **/
    @PostMapping("/addSecKill")
    public RestResponse addSecKill(@RequestBody SecKill param){
        return RestResponse.success(marketFeign.addSecKill(param));
    }

    @GetMapping("/removeSecKill")
    public RestResponse removeSecKill(@RequestParam("id") String id){
        return marketFeign.removeSecKillById(id)?RestResponse.success():RestResponse.error();
    }
    
    /**
    * @Author: 马韬循
    * @Description: 获取秒杀活动中的商品信息
    * @DateTime: 9:30 2021/5/4
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getSecKillCommodBySecKillId")
    public RestResponse getSecKillCommodBySecKillId(@RequestParam("id") String secKillId){
        ArrayList<SecKillCommodVo> secKillCommodVos = new ArrayList<>();
        List<SecCommod> secCommods = marketFeign.listSecCommodBySecId(secKillId);
        for (SecCommod secCommodItem :
                secCommods) {
            CommodBasedinfo commodBasedinfo = commodFeign.getCommodBasedinfoByid(secCommodItem.getComId());
            SecKillCommodVo secKillCommodVo = dozerMapper.map(commodBasedinfo, SecKillCommodVo.class);
            secKillCommodVo.setSecPrice(secCommodItem.getSecPrice());
            secKillCommodVos.add(secKillCommodVo);
        }
        return RestResponse.success(secKillCommodVos);
    }
    
    
    /**
    * @Author: 马韬循
    * @Description: 获取最近的秒杀活动详情
    * @DateTime: 9:59 2021/5/4
    * @Params: 
    * @Return 
    **/
    @GetMapping("/getClosestSecKillId")
    public RestResponse getClosestSecKillId(){
        List<SecKill> secKills = marketFeign.pageSecKill(1, 1000);
        SecKill result = new SecKill();
        String minId=null;
        long minMinute = Long.MAX_VALUE;
        for (SecKill seckillItem :
                secKills) {
            long minute =Duration.between(seckillItem.getSecDateTime(), LocalDateTime.now()).toMinutes();
            if (minute<minMinute){
                minMinute = minute;
                minId = seckillItem.getSecKillId();
                result = seckillItem;
            }
        }
        return minId!=null?RestResponse.success(result):RestResponse.error();
    }
    
}
