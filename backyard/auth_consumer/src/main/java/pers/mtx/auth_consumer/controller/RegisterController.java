package pers.mtx.auth_consumer.controller;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_consumer.entity.ConsumerAuth;
import pers.mtx.auth_consumer.entity.ConsumerInfo;
import pers.mtx.auth_consumer.feign.ConsumerAuthFeign;
import pers.mtx.auth_consumer.feign.ConsumerInfoFeign;
import pers.mtx.auth_consumer.result.RestResponse;
import pers.mtx.auth_consumer.vo.ConsumerRegisterVo;

import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description: 注册控制器
 * @DateTime: 2021/4/5 21:37
 **/
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    Mapper dozerMapper;
    @Autowired
    ConsumerAuthFeign consumerAuthFeign;
    @Autowired
    ConsumerInfoFeign consumerInfoFeign;
    @PostMapping("/consumer")
    public RestResponse Consumer(@RequestBody ConsumerRegisterVo consumerRegister){
        ConsumerAuth auth = new ConsumerAuth();
        ConsumerInfo info = new ConsumerInfo();
        dozerMapper.map(consumerRegister,auth);
        dozerMapper.map(consumerRegister,info);
        ConsumerAuth byEmail = consumerAuthFeign.getByEmail(auth.getConEmail());
        if (byEmail==null){
            String id = UUID.randomUUID().toString();
            auth.setConId(id);
            info.setConId(id);
            consumerAuthFeign.add(auth);
            consumerInfoFeign.add(info);
            return RestResponse.success(id);
        }
        return RestResponse.error("重复");

    }
}
