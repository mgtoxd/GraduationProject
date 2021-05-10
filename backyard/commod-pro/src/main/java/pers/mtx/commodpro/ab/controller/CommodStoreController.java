package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodStore;
import pers.mtx.commodpro.ab.service.ICommodStoreService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品与店铺信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/commod-store")
public class CommodStoreController {
    @Autowired
    private ICommodStoreService iCommodStoreService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodStore param) {
        return iCommodStoreService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodStore> param) {
        return iCommodStoreService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodStore param) {
        return iCommodStoreService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodStore> param) {
        return iCommodStoreService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodStoreService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodStoreService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodStore param) {
        return iCommodStoreService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodStore> param) {
        return iCommodStoreService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodStore> listByIdList(@RequestBody List<String> param) {
        return iCommodStoreService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodStore getByid(@RequestParam("id") String id) {
        return iCommodStoreService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodStore> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodStore> stuPage = new Page<>(count,size);
        QueryWrapper<CommodStore> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodStoreService.page(stuPage,wrapper).getRecords();
    }


}
