package pers.mtx.auth_consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_consumer.entity.*;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/5 22:41
 **/
@FeignClient("auth-provider")
public interface proFeign {
    @PostMapping("/AdminRes/NameExist")
    public Boolean NameExist(@RequestBody String name);

    @PostMapping(value = "/admin-info/add")
    public  Boolean addAdminInfo(@RequestBody AdminInfo param);

    @GetMapping(value = "/admin-auth/pageByModify")
    public List<AdminAuth> pageAdminAuth(@RequestParam("count") Integer count,@RequestParam("size") Integer size);

    @GetMapping(value = "/admin-info/getByid")
    public  AdminInfo getAdminInfoByid(@RequestParam("id") String id);

    @PostMapping("/AdminRes/count")
    public Integer countAdmin();

    @PostMapping(value = "/admin-auth/updateById")
    public  Boolean updateAdminAuthById(@RequestBody AdminAuth param);

    @PostMapping(value = "/admin-info/updateById")
    public  Boolean updateAdminInfoById(@RequestBody AdminInfo param);

    @GetMapping(value = "/admin-info/removeById")
    public  Boolean removeAdminInfoById(@RequestParam("id") String id);

    @GetMapping(value = "/admin-auth/removeById")
    public  Boolean removeAdminAuthById(@RequestParam("id") String id);

    @GetMapping(value = "/consumer-auth/pageByModify")
    public List<ConsumerAuth> pageConsumerAuth(@RequestParam("count") Integer count, @RequestParam("size") Integer size);

    @GetMapping(value = "/consumer-info/getByid")
    public ConsumerInfo getConsumerInfoByid(@RequestParam("id") String id);

    @GetMapping(value = "/consumer-base-info/getByid")
    public ConsumerBaseInfo getConsumerBaseInfoByid(@RequestParam("id") String id);

    @PostMapping(value = "/consumer-base-info/add")
    public  Boolean addConsumerBaseInfo(@RequestBody ConsumerBaseInfo param);
}
