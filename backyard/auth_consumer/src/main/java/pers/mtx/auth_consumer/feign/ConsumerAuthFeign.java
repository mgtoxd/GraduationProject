package pers.mtx.auth_consumer.feign;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_consumer.entity.ConsumerAuth;

@FeignClient("auth-provider")
@RequestMapping("/consumer-auth")
public interface ConsumerAuthFeign {

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerAuth param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerAuth> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerAuth param);
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerAuth> param) ;
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerAuth param) ;
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerAuth> param) ;
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerAuth> listByIdList(@RequestBody List<String> param);
    @GetMapping(value = "/getByEmail")
    public  ConsumerAuth getByEmail(@RequestParam("email") String email);
    @GetMapping(value = "/getByid")
    public  ConsumerAuth getByid(@RequestParam("id") String id);
    @GetMapping(value = "/pageByModify")
    public List<ConsumerAuth> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
