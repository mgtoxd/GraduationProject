package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerInfo;
import pers.mtx.auth_provider.ab.service.IConsumerInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费者详细信息表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/consumer-info")
public class ConsumerInfoController {
    @Autowired
    private IConsumerInfoService iConsumerInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerInfo param) {
        return iConsumerInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerInfo> param) {
        return iConsumerInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerInfo param) {
        return iConsumerInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerInfo> param) {
        return iConsumerInfoService.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iConsumerInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iConsumerInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerInfo param) {
        return iConsumerInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerInfo> param) {
        return iConsumerInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerInfo> listByIdList(@RequestBody List<String> param) {
        return iConsumerInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  ConsumerInfo getByid(@RequestParam("id") String id) {
        return iConsumerInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<ConsumerInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerInfo> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerInfoService.page(stuPage,wrapper).getRecords();
    }


}
