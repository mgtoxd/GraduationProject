package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerBaseInfo;
import pers.mtx.auth_provider.ab.service.IConsumerBaseInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 消费者常用信息表 前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-04-26
*/
    @RestController
@RequestMapping("/consumer-base-info")
    public class ConsumerBaseInfoController {
@Autowired
private IConsumerBaseInfoService iConsumerBaseInfoService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody ConsumerBaseInfo param) {
return iConsumerBaseInfoService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<ConsumerBaseInfo> param) {
return iConsumerBaseInfoService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody ConsumerBaseInfo param) {
return iConsumerBaseInfoService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<ConsumerBaseInfo> param) {
return iConsumerBaseInfoService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iConsumerBaseInfoService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iConsumerBaseInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerBaseInfo param) {
    return iConsumerBaseInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerBaseInfo> param) {
    return iConsumerBaseInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerBaseInfo> listByIdList(@RequestBody List<String> param) {
        return iConsumerBaseInfoService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  ConsumerBaseInfo getByid(@RequestParam("id") String id) {
        return iConsumerBaseInfoService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<ConsumerBaseInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerBaseInfo> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerBaseInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerBaseInfoService.page(stuPage,wrapper).getRecords();
        }


        }
