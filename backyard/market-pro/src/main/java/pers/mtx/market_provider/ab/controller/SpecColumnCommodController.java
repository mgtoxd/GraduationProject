package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.SpecColumnCommod;
import pers.mtx.market_provider.ab.service.ISpecColumnCommodService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 专栏和商品关联表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/spec-column-commod")
public class SpecColumnCommodController {
    @Autowired
    private ISpecColumnCommodService iSpecColumnCommodService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody SpecColumnCommod param) {
        return iSpecColumnCommodService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<SpecColumnCommod> param) {
        return iSpecColumnCommodService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody SpecColumnCommod param) {
        return iSpecColumnCommodService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<SpecColumnCommod> param) {
        return iSpecColumnCommodService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iSpecColumnCommodService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iSpecColumnCommodService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody SpecColumnCommod param) {
        return iSpecColumnCommodService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<SpecColumnCommod> param) {
        return iSpecColumnCommodService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<SpecColumnCommod> listByIdList(@RequestBody List<String> param) {
        return iSpecColumnCommodService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  SpecColumnCommod getByid(@RequestParam("id") String id) {
        return iSpecColumnCommodService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<SpecColumnCommod> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<SpecColumnCommod> stuPage = new Page<>(count,size);
        QueryWrapper<SpecColumnCommod> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iSpecColumnCommodService.page(stuPage,wrapper).getRecords();
    }


}
