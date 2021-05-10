package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodSku;
import pers.mtx.commodpro.ab.service.ICommodSkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品库存表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/commod-sku")
public class CommodSkuController {
    @Autowired
    private ICommodSkuService iCommodSkuService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodSku param) {
        return iCommodSkuService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodSku> param) {
        return iCommodSkuService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodSku param) {
        return iCommodSkuService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodSku> param) {
        return iCommodSkuService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodSkuService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodSkuService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodSku param) {
        return iCommodSkuService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodSku> param) {
        return iCommodSkuService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodSku> listByIdList(@RequestBody List<String> param) {
        return iCommodSkuService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodSku getByid(@RequestParam("id") String id) {
        return iCommodSkuService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodSku> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodSku> stuPage = new Page<>(count,size);
        QueryWrapper<CommodSku> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodSkuService.page(stuPage,wrapper).getRecords();
    }


}
