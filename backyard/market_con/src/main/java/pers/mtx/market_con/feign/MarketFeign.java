package pers.mtx.market_con.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.market_con.entity.IndexPos;
import pers.mtx.market_con.entity.IndexShowCommod;
import pers.mtx.market_con.entity.SecCommod;
import pers.mtx.market_con.entity.SecKill;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description: 营销模块feign
 * @DateTime: 2021/4/30 16:22
 **/
@FeignClient("market-provider")
public interface MarketFeign {


    @GetMapping(value = "/index-show-commod/pageByModify")
    public List<IndexShowCommod> page(@RequestParam("count") Integer count, @RequestParam("size") Integer size);

    @GetMapping("/index/getindexinfoByCommodId")
    public List<IndexShowCommod> listindexinfoByCommodId(@RequestParam("id") String id);

    @GetMapping(value = "/index-pos/pageByModify")
    public List<IndexPos> pageIndexPos(@RequestParam("count") Integer count, @RequestParam("size") Integer size);

    @PostMapping(value = "/index-show-commod/addList")
    public  Boolean addIndexShowCommodListList(@RequestBody List<IndexShowCommod> param);

    @GetMapping("/index/removeIndexShowCommodByCommodId")
    public Boolean removeIndexShowCommodByCommodId(@RequestParam("id") String id);

    @PostMapping(value = "/index-show-commod/addOrUpdateList")
    public  Boolean addOrUpdateIndexShowCommodList(@RequestBody List<IndexShowCommod> param);
    @GetMapping(value = "/index-show-commod/removeById")
    public  Boolean removeIndexShowCommodById(@RequestParam("id") String id);

    @GetMapping(value = "/index-pos/getByid")
    public  IndexPos getIndexPosByid(@RequestParam("id") String id);

    @PostMapping(value = "/index-show-commod/updateById")
    public  Boolean updateIndexShowCommodById(@RequestBody IndexShowCommod param);



    @PostMapping(value = "/sec-commod/addOrUpdate")
    public  Boolean addOrUpdateSecKillCommod(@RequestBody SecCommod param);

    @GetMapping("/Sec/getSecKByCommodId")
    public SecCommod getSecKByCommodId(@RequestParam("id") String id);

    @GetMapping(value = "/sec-kill/pageByModify")
    public List<SecKill> pageSecKill(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


    @PostMapping(value = "/sec-kill/add")
    public  Boolean addSecKill(@RequestBody SecKill param);

    @GetMapping(value = "/sec-kill/removeById")
    public  Boolean removeSecKillById(@RequestParam("id") String id);

    @GetMapping(value = "/sec-kill/getByid")
    public  SecKill getSecKillByid(@RequestParam("id") String id);
    @GetMapping("/Sec/listSecCommodBySecId")
    public List<SecCommod> listSecCommodBySecId(@RequestParam("id") String id);

}
