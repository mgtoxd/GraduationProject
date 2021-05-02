package pers.mtx.auth_consumer.controller;

import com.alibaba.nacos.common.utils.MD5Utils;
import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_consumer.entity.*;
import pers.mtx.auth_consumer.feign.*;
import pers.mtx.auth_consumer.result.RestResponse;
import pers.mtx.auth_consumer.vo.AdminLoginVo;
import pers.mtx.auth_consumer.vo.ConsumerRegisterVo;

import javax.websocket.server.PathParam;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    proFeign proFeign;
    @Autowired
    AdminAuthFeign adminAuthFeign;
    @Autowired
    Mapper dozerMapper;
    @Autowired
    ConsumerAuthFeign consumerAuthFeign;
    @Autowired
    ConsumerInfoFeign consumerInfoFeign;
    @Autowired
    ConsumerFeign consumerFeign;
    @PostMapping("/consumer")
    public RestResponse Consumer(@RequestBody ConsumerRegisterVo consumerRegister){
        ConsumerAuth auth = new ConsumerAuth();
        ConsumerInfo info = new ConsumerInfo();
        dozerMapper.map(consumerRegister,auth);
        dozerMapper.map(consumerRegister,info);
        ConsumerBaseInfo baseInfo = dozerMapper.map(consumerRegister, ConsumerBaseInfo.class);

        info.setConBirthday(consumerRegister.getConBirthday());
        auth.setConPassword(DigestUtils.md5DigestAsHex(auth.getConPassword().getBytes()));
        if (!consumerFeign.exists(auth.getConEmail(), auth.getConPhoneNum())){
            String id = UUID.randomUUID().toString();
            auth.setConId(id);
            info.setConId(id);
            baseInfo.setConId(id);
            consumerAuthFeign.add(auth);
            proFeign.addConsumerBaseInfo(baseInfo);
            consumerInfoFeign.add(info);
            return RestResponse.success(id);
        }
        return RestResponse.error(250,"重复");

    }
    /**
    * @Author: 马韬循
    * @Description: 注册管理员
    * @DateTime: 9:03 2021/4/26
    * @Params:
    * @Return
    **/
    @PostMapping("/admin")
    public RestResponse admin(@RequestBody AdminLoginVo admin) throws NoSuchAlgorithmException {
        String newAdminId = UUID.randomUUID().toString();
        AdminAuth adminAuth = dozerMapper.map(admin, AdminAuth.class);
        AdminInfo adminInfo = dozerMapper.map(admin, AdminInfo.class);
        adminAuth.setAdminId(newAdminId);
        adminInfo.setAdminId(newAdminId);
        adminAuth.setAdminPassword(DigestUtils.md5DigestAsHex(adminAuth.getAdminPassword().getBytes()));
        if (proFeign.NameExist(adminAuth.getAdminName())){
            return RestResponse.error("nameExist");
        }
        if (adminAuthFeign.add(adminAuth)&&proFeign.addAdminInfo(adminInfo)){
            return RestResponse.success("registerAdmin success");
        }
        return RestResponse.error();
    }

    /**
    * @Author: 马韬循
    * @Description: 检查用户名是否存在
    * @DateTime: 10:22 2021/4/26
    * @Params:
    * @Return
    **/
    @GetMapping("/adminExist")
    public RestResponse adminExist(@PathParam("name") String name){
        if (proFeign.NameExist(name)){
            return RestResponse.error("nameExist");
        }
        return RestResponse.success();
    }
}
