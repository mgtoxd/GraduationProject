package pers.mtx.market_con.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.market_con.entity.CommodBasedinfo;
import pers.mtx.market_con.entity.IndexPos;
import pers.mtx.market_con.entity.IndexShowCommod;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description: 商品模块提供者feign
 * @DateTime: 2021/4/30 16:22
 **/
@FeignClient("commod-provider")
public interface CommodFeign {
    @GetMapping(value = "/commod-basedinfo/getByid")
    public CommodBasedinfo getCommodBasedinfoByid(@RequestParam("id") String id);

}
