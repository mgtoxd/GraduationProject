package pers.mtx.auth_consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_consumer.entity.AdminAuth;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/5 22:41
 **/
@FeignClient("auth-provider")
@RequestMapping("")
public interface AdminAuthFeign {
    @PostMapping(value = "/add")
    Boolean add(@RequestBody AdminAuth param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<AdminAuth> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody AdminAuth param);
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<AdminAuth> param) ;
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody AdminAuth param);
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<AdminAuth> param);
    @PostMapping(value = "/listByIdList")
    public  List<AdminAuth> listByIdList(@RequestBody List<String> param);

    @PostMapping(value = "/getByid")
    public  AdminAuth getByid(@RequestParam("id") String id);
    @GetMapping(value = "/pageByModify")
    public List<AdminAuth> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);

}
