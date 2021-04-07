package pers.mtx.auth_consumer.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_consumer.feign.TokenFeign;

/**
 * @Author: 马韬循
 * @Description: 验证控制器
 * @DateTime: 2021/4/7 20:59
 **/
@RestController
public class CheckController {
    @Autowired
    Mapper dozerMapper;
    @Autowired
    TokenFeign tokenFeign;
    @PostMapping("/checkToken")
    public boolean whetherConsumer(@RequestBody String token){
        return tokenFeign.whetherConsumer(token);
    }
}
