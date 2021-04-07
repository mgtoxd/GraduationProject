package pers.mtx.auth_consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/7 22:54
 **/
@FeignClient("auth-provider")
@RequestMapping("/Consumer")
public interface ConsumerFeign {
    @GetMapping("/exists")
    public boolean exists(@RequestParam("email") String email,@RequestParam("phone") String phone);
}
