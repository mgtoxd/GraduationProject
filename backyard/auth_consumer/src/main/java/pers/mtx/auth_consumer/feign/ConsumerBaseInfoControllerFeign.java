package pers.mtx.auth_consumer.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 消费者常用信息表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
import pers.mtx.auth_consumer.entity.*;
@FeignClient("auth-provider")
@RequestMapping("/consumer-base-info")
public interface ConsumerBaseInfoControllerFeign {


    @PostMapping(value = "/add")
    public Boolean add(@RequestBody ConsumerBaseInfo param);

    @PostMapping(value = "/addList")
    public Boolean addList(@RequestBody List<ConsumerBaseInfo> param);

    @PostMapping(value = "/addOrUpdate")
    public Boolean addOrUpdate(@RequestBody ConsumerBaseInfo param);

    @PostMapping(value = "/addOrUpdateList")
    public Boolean addOrUpdateList(@RequestBody List<ConsumerBaseInfo> param);

    @GetMapping(value = "/removeById")
    public Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
    public Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public Boolean updateById(@RequestBody ConsumerBaseInfo param);

    @PostMapping(value = "/updateListById")
    public Boolean updateBatchById(@RequestBody List<ConsumerBaseInfo> param);

    @PostMapping(value = "/listByIdList")
    public List<ConsumerBaseInfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public ConsumerBaseInfo getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<ConsumerBaseInfo> page(@RequestParam("count") Integer count, @RequestParam("size") Integer size);


}
