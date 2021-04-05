package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerLevel;
import pers.mtx.auth_provider.ab.service.IConsumerLevelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费者与等级绑定表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/consumer-level")
public class ConsumerLevelController {
    @Autowired
    private IConsumerLevelService iConsumerLevelService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerLevel param) {
        return iConsumerLevelService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerLevel> param) {
        return iConsumerLevelService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerLevel param) {
        return iConsumerLevelService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerLevel> param) {
        return iConsumerLevelService.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iConsumerLevelService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iConsumerLevelService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerLevel param) {
        return iConsumerLevelService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerLevel> param) {
        return iConsumerLevelService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerLevel> listByIdList(@RequestBody List<String> param) {
        return iConsumerLevelService.listByIds(param);
    }

    @PostMapping(value = "/getByid")
    public  ConsumerLevel getByid(@RequestParam("id") String id) {
        return iConsumerLevelService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<ConsumerLevel> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerLevel> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerLevel> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerLevelService.page(stuPage,wrapper).getRecords();
    }


}
