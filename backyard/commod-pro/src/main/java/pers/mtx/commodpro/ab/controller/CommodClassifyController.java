package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodClassify;
import pers.mtx.commodpro.ab.service.ICommodClassifyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品分类关联表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/commod-classify")
public class CommodClassifyController {
    @Autowired
    private ICommodClassifyService iCommodClassifyService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodClassify param) {
        return iCommodClassifyService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodClassify> param) {
        return iCommodClassifyService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodClassify param) {
        return iCommodClassifyService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodClassify> param) {
        return iCommodClassifyService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodClassifyService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodClassifyService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodClassify param) {
        return iCommodClassifyService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodClassify> param) {
        return iCommodClassifyService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodClassify> listByIdList(@RequestBody List<String> param) {
        return iCommodClassifyService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodClassify getByid(@RequestParam("id") String id) {
        return iCommodClassifyService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodClassify> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodClassify> stuPage = new Page<>(count,size);
        QueryWrapper<CommodClassify> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodClassifyService.page(stuPage,wrapper).getRecords();
    }


}
