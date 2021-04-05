package pers.mtx.auth_consumer.feign;
import lombok.Data;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import pers.mtx.auth_consumer.entity.ConsumerInfo;

@FeignClient("auth-provider")
@RequestMapping("/consumer-info")
public interface ConsumerInfoFeign {
    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerInfo param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerInfo> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerInfo param) ;
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerInfo> param);
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) ;
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerInfo param) ;
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerInfo> param);
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerInfo> listByIdList(@RequestBody List<String> param);

    @PostMapping(value = "/getByid")
    public  ConsumerInfo getByid(@RequestParam("id") String id);
    @GetMapping(value = "/pageByModify")
    public List<ConsumerInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}