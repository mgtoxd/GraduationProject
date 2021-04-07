package pers.mtx.auth_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_provider.ab.entity.ConsumerAuth;
import pers.mtx.auth_provider.ab.service.IConsumerAuthService;
import pers.mtx.auth_provider.util.RedisUtil;

import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/7 21:45
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    IConsumerAuthService consumerAuthService;

    @PostMapping("/LoginByEmail")
    public String LoginByEmail(@RequestBody ConsumerAuth auth){
        ConsumerAuth conByEmail = consumerAuthService.getOne(new QueryWrapper<ConsumerAuth>().eq("con_email", auth.getConEmail()));
        if (conByEmail==null) return "用户不存在";
        if (!conByEmail.getConPassword().equals(DigestUtils.md5DigestAsHex(auth.getConPassword().getBytes()))) return "用户名或密码错误";

        String key = UUID.randomUUID().toString()+"c";
        redisUtil.set(key,conByEmail.getConId(),90);
        return key;

    }
    @PostMapping("/LoginByPhoneNum")
    public String LoginByPhoneNum(@RequestBody ConsumerAuth auth){
        ConsumerAuth conByEmail = consumerAuthService.getOne(new QueryWrapper<ConsumerAuth>().eq("con_phone_num", auth.getConPhoneNum()));
        if (conByEmail==null) return "用户不存在";
        if (!conByEmail.getConPassword().equals(DigestUtils.md5DigestAsHex(auth.getConPassword().getBytes()))) return "用户名或密码错误";

        String key = UUID.randomUUID().toString()+"c";
        redisUtil.set(key,conByEmail.getConId(),90);
        return key;
    }
}
