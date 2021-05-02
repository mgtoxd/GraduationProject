package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodPriceDate;
import pers.mtx.commodpro.ab.service.ICommodPriceDateService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品特殊日期价格表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/commod-price-date")
public class CommodPriceDateController {
    @Autowired
    private ICommodPriceDateService iCommodPriceDateService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodPriceDate param) {
        return iCommodPriceDateService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodPriceDate> param) {
        return iCommodPriceDateService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodPriceDate param) {
        return iCommodPriceDateService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodPriceDate> param) {
        return iCommodPriceDateService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodPriceDateService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodPriceDateService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodPriceDate param) {
        return iCommodPriceDateService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodPriceDate> param) {
        return iCommodPriceDateService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodPriceDate> listByIdList(@RequestBody List<String> param) {
        return iCommodPriceDateService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodPriceDate getByid(@RequestParam("id") String id) {
        return iCommodPriceDateService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodPriceDate> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodPriceDate> stuPage = new Page<>(count,size);
        QueryWrapper<CommodPriceDate> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodPriceDateService.page(stuPage,wrapper).getRecords();
    }


}
