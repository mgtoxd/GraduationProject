package pers.mtx.auth_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_provider.ab.entity.AdminAuth;
import pers.mtx.auth_provider.ab.service.IAdminAuthService;

/**
 * @Author: 马韬循
 * @Description: 管理员
 * @DateTime: 2021/4/26 9:06
 **/
@RestController
@RequestMapping("/AdminRes")
public class AdminResController {
    @Autowired
    IAdminAuthService adminAuthService;
    /**
    * @Author: 马韬循
    * @Description: 查询管理员姓名是否重复
    * @DateTime: 9:11 2021/4/26
    * @Params:
    * @Return
    **/
    @PostMapping("/NameExist")
    public Boolean NameExist(@RequestBody String name){
        int countAdmin = adminAuthService.count(new QueryWrapper<AdminAuth>().eq("admin_name", name));
        return countAdmin != 0;
    }

    @PostMapping("/count")
    public Integer count(){
        return adminAuthService.count();
    }
}
