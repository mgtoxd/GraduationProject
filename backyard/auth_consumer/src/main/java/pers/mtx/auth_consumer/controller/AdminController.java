package pers.mtx.auth_consumer.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_consumer.entity.AdminAuth;
import pers.mtx.auth_consumer.entity.AdminInfo;
import pers.mtx.auth_consumer.feign.proFeign;
import pers.mtx.auth_consumer.result.RestResponse;
import pers.mtx.auth_consumer.vo.AdminInfoVo;
import pers.mtx.auth_consumer.vo.AdminLoginVo;
import pers.mtx.auth_consumer.vo.AdminUpdateVo;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/26 10:56
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    proFeign profeign;
    @Autowired
    Mapper dozerMapper;
    /**
    * @Author: 马韬循
    * @Description: 分页查询
    * @DateTime: 11:47 2021/4/26
    * @Params:
    * @Return
    **/
    @GetMapping("page")
    public RestResponse page(@RequestParam("count") Integer count, @RequestParam("size") Integer size){
        List<AdminAuth> adminAuths = profeign.pageAdminAuth(count, size);
        ArrayList<AdminInfoVo> adminInfoVos = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        for ( AdminAuth adminauth: adminAuths) {
            AdminInfo info = profeign.getAdminInfoByid(adminauth.getAdminId());
            AdminInfoVo adminInfoVo = new AdminInfoVo();
            dozerMapper.map(adminauth,adminInfoVo);
            adminInfoVo.setDate(adminauth.getCreateDate());
            adminInfoVo.setJobnumber(info.getJobnumber());
            adminInfoVos.add(adminInfoVo);
        }
        map.put("pageNum",profeign.countAdmin()/size);
        map.put("list",adminInfoVos);
        return RestResponse.success(map);
    }

    /**
    * @Author: 马韬循
    * @Description: 修改admin
    * @DateTime: 12:03 2021/4/26
    * @Params: 
    * @Return 
    **/
    @PostMapping("/updateAdmin")
    public RestResponse updateAdmin(@RequestBody AdminUpdateVo adminUpdateVo){
        AdminAuth adminAuth = dozerMapper.map(adminUpdateVo, AdminAuth.class);
        adminAuth.setAdminPassword(DigestUtils.md5DigestAsHex(adminAuth.getAdminPassword().getBytes()));
        AdminInfo adminInfo = dozerMapper.map(adminUpdateVo, AdminInfo.class);
        if (profeign.updateAdminAuthById(adminAuth) && profeign.updateAdminInfoById(adminInfo)){
            return RestResponse.success("修改成功");
        }
        return RestResponse.error();
    }

    /**
     * @Author: 马韬循
     * @Description: 删除admin
     * @DateTime: 12:26 2021/4/26
     * @Params:
     * @Return
     **/
    @GetMapping("/deleteAdmin")
    public RestResponse deleteAdmin(@PathParam("id") String id){
        if (profeign.removeAdminAuthById(id)&& profeign.removeAdminInfoById(id)){
            return RestResponse.success();
        }
        return RestResponse.error();
    }
}
