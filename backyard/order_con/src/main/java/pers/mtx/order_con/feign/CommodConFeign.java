package pers.mtx.order_con.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.order_con.entity.CommodBasedinfo;
import pers.mtx.order_con.result.RestResponse;
import pers.mtx.order_con.vo.SetCommod;

@FeignClient("commod-consumer")
public interface CommodConFeign {

    @RequestMapping("/commod/Commod/setCommod")
    public RestResponse setCommod(@RequestBody SetCommod commod);

}
