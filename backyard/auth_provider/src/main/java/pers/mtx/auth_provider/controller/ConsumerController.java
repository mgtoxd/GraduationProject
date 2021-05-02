package pers.mtx.auth_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_provider.ab.entity.ConsumerAuth;
import pers.mtx.auth_provider.ab.service.IConsumerAuthService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/7 22:54
 **/
@RestController
@RequestMapping("/Consumer")
public class ConsumerController {
    @Autowired
    IConsumerAuthService consumerAuthService;

    @GetMapping("/exists")
    public boolean exists(@RequestParam("email") String email,@RequestParam("phone") String phone){
        List<ConsumerAuth> list = consumerAuthService.list(new QueryWrapper<ConsumerAuth>().eq("con_email", email).or().eq("con_phone_num", phone));
        return list.size()!=0;
    }

    @PostMapping("/count")
    public Integer count(){
        return consumerAuthService.count();
    }

}
