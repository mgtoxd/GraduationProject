package pers.mtx.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.pay.entity.OrderInfo;

import java.util.List;

@FeignClient("order-provider")
//@Repository
public interface ClassifyFeign {
    @PostMapping(value = "/order-info/updateById")
    public  Boolean updateById(@RequestBody OrderInfo param);

}
