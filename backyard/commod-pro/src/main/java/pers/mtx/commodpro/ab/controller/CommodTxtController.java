package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodTxt;
import pers.mtx.commodpro.ab.service.ICommodTxtService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品详细描述 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/commod-txt")
public class CommodTxtController {
    @Autowired
    private ICommodTxtService iCommodTxtService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodTxt param) {
        return iCommodTxtService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodTxt> param) {
        return iCommodTxtService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodTxt param) {
        return iCommodTxtService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodTxt> param) {
        return iCommodTxtService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodTxtService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodTxtService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodTxt param) {
        return iCommodTxtService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodTxt> param) {
        return iCommodTxtService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodTxt> listByIdList(@RequestBody List<String> param) {
        return iCommodTxtService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodTxt getByid(@RequestParam("id") String id) {
        return iCommodTxtService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodTxt> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodTxt> stuPage = new Page<>(count,size);
        QueryWrapper<CommodTxt> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodTxtService.page(stuPage,wrapper).getRecords();
    }


}
