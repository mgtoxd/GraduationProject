package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.SecKill;
import pers.mtx.market_provider.ab.service.ISecKillService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 秒杀活动表  前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-02
 */
@RestController
@RequestMapping("/sec-kill")
public class SecKillController {
    @Autowired
    private ISecKillService iSecKillService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody SecKill param) {
        return iSecKillService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<SecKill> param) {
        return iSecKillService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody SecKill param) {
        return iSecKillService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<SecKill> param) {
        return iSecKillService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iSecKillService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iSecKillService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody SecKill param) {
        return iSecKillService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<SecKill> param) {
        return iSecKillService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<SecKill> listByIdList(@RequestBody List<String> param) {
        return iSecKillService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  SecKill getByid(@RequestParam("id") String id) {
        return iSecKillService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<SecKill> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<SecKill> stuPage = new Page<>(count,size);
        QueryWrapper<SecKill> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iSecKillService.page(stuPage,wrapper).getRecords();
    }


}
