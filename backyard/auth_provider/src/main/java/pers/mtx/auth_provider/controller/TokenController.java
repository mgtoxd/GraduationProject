package pers.mtx.auth_provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_provider.service.tokenService;

/**
 * @Author: 马韬循
 * @Description: token相关控制器
 * @DateTime: 2021/4/7 21:02
 **/
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    tokenService service;
    /**
    * @Author: 马韬循
    * @Description: 验证token
    * @DateTime: 21:05 2021/4/7
    * @Params:
    * @Return
    **/
    @PostMapping("/checkToken")
    public boolean whetherConsumer(@RequestBody String token){
        return service.checkToken(token);
    }
}
