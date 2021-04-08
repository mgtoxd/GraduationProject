package pers.mtx.gateway.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 马韬循
 * @Description: 验证控制器
 * @DateTime: 2021/4/7 20:59
 **/
@FeignClient("auth-consumer")
@RestController
public interface CheckFeign {

    @PostMapping("/checkToken")
    public boolean whetherConsumer(@RequestBody String token);
}
