package pers.mtx.comments_con.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.comments_con.entity.ConsumerBaseInfo;

@FeignClient("auth-provider")
public interface AuthProFeign {

    @GetMapping("/token/getConsumerBytoken")
    public String  getConsumerBytoken(@RequestParam("token") String token);

    @GetMapping(value = "/consumer-base-info/getByid")
    public ConsumerBaseInfo getConsumerBaseInfoByid(@RequestParam("id") String id);
}
