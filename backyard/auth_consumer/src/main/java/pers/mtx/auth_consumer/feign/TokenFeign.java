package pers.mtx.auth_consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 马韬循
 * @Description: token相关控制器
 * @DateTime: 2021/4/7 21:02
 **/
@FeignClient("auth-provider")
@RequestMapping("/token")
public interface TokenFeign {


    /**
    * @Author: 马韬循
    * @Description: 验证token
    * @DateTime: 21:05 2021/4/7
    * @Params:
    * @Return
    **/
    @PostMapping("/checkToken")
    public boolean whetherConsumer(@RequestBody String token);
    @PostMapping("/checkAdminToken")
    public boolean whetherAdmin(@RequestBody String token);

    @GetMapping("/getConsumerBytoken")
    public String  getConsumerBytoken(@RequestParam("token") String token);
}
