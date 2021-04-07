package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerAuth;
import pers.mtx.auth_provider.ab.service.IConsumerAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费者认证表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/consumer-auth")
public class ConsumerAuthController {
    @Autowired
    private IConsumerAuthService iConsumerAuthService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ConsumerAuth param) {
        return iConsumerAuthService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ConsumerAuth> param) {
        return iConsumerAuthService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ConsumerAuth param) {
        return iConsumerAuthService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ConsumerAuth> param) {
        return iConsumerAuthService.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iConsumerAuthService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iConsumerAuthService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerAuth param) {
        return iConsumerAuthService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerAuth> param) {
        return iConsumerAuthService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerAuth> listByIdList(@RequestBody List<String> param) {
        return iConsumerAuthService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  ConsumerAuth getByid(@RequestParam("id") String id) {
        return iConsumerAuthService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<ConsumerAuth> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerAuth> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerAuth> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerAuthService.page(stuPage,wrapper).getRecords();
    }


}
