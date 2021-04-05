package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerPrivilege;
import pers.mtx.auth_provider.ab.service.IConsumerPrivilegeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费者特权表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/consumer-privilege")
public class ConsumerPrivilegeController {
    @Autowired
    private IConsumerPrivilegeService iConsumerPrivilegeService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerPrivilege param) {
        return iConsumerPrivilegeService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerPrivilege> param) {
        return iConsumerPrivilegeService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerPrivilege param) {
        return iConsumerPrivilegeService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerPrivilege> param) {
        return iConsumerPrivilegeService.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iConsumerPrivilegeService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iConsumerPrivilegeService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerPrivilege param) {
        return iConsumerPrivilegeService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerPrivilege> param) {
        return iConsumerPrivilegeService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerPrivilege> listByIdList(@RequestBody List<String> param) {
        return iConsumerPrivilegeService.listByIds(param);
    }

    @PostMapping(value = "/getByid")
    public  ConsumerPrivilege getByid(@RequestParam("id") String id) {
        return iConsumerPrivilegeService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<ConsumerPrivilege> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerPrivilege> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerPrivilege> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerPrivilegeService.page(stuPage,wrapper).getRecords();
    }


}
