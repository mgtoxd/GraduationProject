package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodBasedinfo;
import pers.mtx.commodpro.ab.service.ICommodBasedinfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品基础信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/commod-basedinfo")
public class CommodBasedinfoController {
    @Autowired
    private ICommodBasedinfoService iCommodBasedinfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodBasedinfo param) {
        return iCommodBasedinfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodBasedinfo> param) {
        return iCommodBasedinfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodBasedinfo param) {
        return iCommodBasedinfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodBasedinfo> param) {
        return iCommodBasedinfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodBasedinfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodBasedinfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodBasedinfo param) {
        return iCommodBasedinfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodBasedinfo> param) {
        return iCommodBasedinfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodBasedinfo> listByIdList(@RequestBody List<String> param) {
        return iCommodBasedinfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodBasedinfo getByid(@RequestParam("id") String id) {
        return iCommodBasedinfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodBasedinfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodBasedinfo> stuPage = new Page<>(count,size);
        QueryWrapper<CommodBasedinfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodBasedinfoService.page(stuPage,wrapper).getRecords();
    }


}
