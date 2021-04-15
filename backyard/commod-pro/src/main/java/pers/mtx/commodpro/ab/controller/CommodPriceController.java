package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodPrice;
import pers.mtx.commodpro.ab.service.ICommodPriceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品价格表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/commod-price")
public class CommodPriceController {
    @Autowired
    private ICommodPriceService iCommodPriceService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodPrice param) {
        return iCommodPriceService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodPrice> param) {
        return iCommodPriceService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodPrice param) {
        return iCommodPriceService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodPrice> param) {
        return iCommodPriceService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodPriceService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodPriceService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodPrice param) {
        return iCommodPriceService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodPrice> param) {
        return iCommodPriceService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodPrice> listByIdList(@RequestBody List<String> param) {
        return iCommodPriceService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodPrice getByid(@RequestParam("id") String id) {
        return iCommodPriceService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodPrice> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodPrice> stuPage = new Page<>(count,size);
        QueryWrapper<CommodPrice> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodPriceService.page(stuPage,wrapper).getRecords();
    }


}
