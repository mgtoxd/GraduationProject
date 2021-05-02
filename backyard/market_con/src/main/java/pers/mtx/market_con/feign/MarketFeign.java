package pers.mtx.market_con.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.market_con.entity.IndexPos;
import pers.mtx.market_con.entity.IndexShowCommod;

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
}
