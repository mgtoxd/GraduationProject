package pers.mtx.auth_consumer.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_consumer.entity.ConsumerAuth;
import pers.mtx.auth_consumer.feign.ConsumerAuthFeign;
import pers.mtx.auth_consumer.feign.LoginFeign;
import pers.mtx.auth_consumer.result.RestResponse;
import pers.mtx.auth_consumer.vo.ConsumerLoginVo;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @Author: 马韬循
 * @Description: 登录控制器
 * @DateTime: 2021/4/7 20:59
 **/
@RestController
public class LoginController {
    @Autowired
    ConsumerAuthFeign consumerAuthFeign;
    @Autowired
    LoginFeign loginFeign;
    @Autowired
    Mapper dozerMapper;
    /**
    * @Author: 马韬循
    * @Description: 消费者登录
    * @DateTime: 21:40 2021/4/7
    * @Params:
    * @Return
    **/
    @PostMapping("/ConsumerLogin")
    public RestResponse ConsumerLogin(@RequestBody ConsumerLoginVo loginVo){

        ConsumerAuth consumerAuth = new ConsumerAuth();
        if (loginVo.getType().equals("email")){
            consumerAuth.setConEmail(loginVo.getUser()).setConPassword(loginVo.getPassword());
            return RestResponse.success(loginFeign.LoginByEmail(consumerAuth));
        }else {
            consumerAuth.setConPhoneNum(loginVo.getUser()).setConPassword(loginVo.getPassword());
            return RestResponse.success(loginFeign.LoginByEmail(consumerAuth));
        }
    }
}
