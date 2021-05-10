package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.result.RestResponse;

import java.util.List;

@FeignClient("market-consumer")
//@Repository
public interface MarketCFeign {
    @GetMapping("/market/index/removeIndexInfoByCommodId")
    public RestResponse removeIndexInfoByCommodId(@RequestParam("id") String id);


}
