package pers.mtx.market_con.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.market_con.entity.*;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description: 营销模块专栏feign
 * @DateTime: 2021/4/30 16:22
 **/
@FeignClient("market-provider")
public interface MarketSpecColumnFeign {

    @GetMapping(value = "/spec-column/pageByModify")
    public List<SpecColumn> pageSpecColumn(@RequestParam("count") Integer count, @RequestParam("size") Integer size);

    @GetMapping("/SpecColumn/listSpecColumnCommodBycommodId")
    public List<SpecColumnCommod> listSpecColumnCommodBycommodId(@RequestParam("id") String commodId);

    @PostMapping(value = "/spec-column-commod/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<SpecColumnCommod> param);

    @PostMapping(value = "/spec-column/add")
    public  Boolean addSpecColumn(@RequestBody SpecColumn param);

    @GetMapping("/SpecColumn/listBySpecColumnId")
    public List<SpecColumnCommod> listBySpecColumnId(@RequestParam("id") String id);

    @GetMapping(value = "/spec-column-commod/removeById")
    public  Boolean removeSpecColumnCommodById(@RequestParam("id") String id);
}
