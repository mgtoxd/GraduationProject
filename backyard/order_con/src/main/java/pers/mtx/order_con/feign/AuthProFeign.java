package pers.mtx.order_con.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("auth-provider")
public interface AuthProFeign {

    @GetMapping("/token/getConsumerBytoken")
    public String  getConsumerBytoken(@RequestParam("token") String token);
}
