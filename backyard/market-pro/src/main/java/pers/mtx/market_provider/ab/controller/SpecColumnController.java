package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.SpecColumn;
import pers.mtx.market_provider.ab.service.ISpecColumnService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 专栏管理表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/spec-column")
public class SpecColumnController {
    @Autowired
    private ISpecColumnService iSpecColumnService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody SpecColumn param) {
        return iSpecColumnService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<SpecColumn> param) {
        return iSpecColumnService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody SpecColumn param) {
        return iSpecColumnService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<SpecColumn> param) {
        return iSpecColumnService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iSpecColumnService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iSpecColumnService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody SpecColumn param) {
        return iSpecColumnService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<SpecColumn> param) {
        return iSpecColumnService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<SpecColumn> listByIdList(@RequestBody List<String> param) {
        return iSpecColumnService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  SpecColumn getByid(@RequestParam("id") String id) {
        return iSpecColumnService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<SpecColumn> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<SpecColumn> stuPage = new Page<>(count,size);
        QueryWrapper<SpecColumn> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iSpecColumnService.page(stuPage,wrapper).getRecords();
    }


}
