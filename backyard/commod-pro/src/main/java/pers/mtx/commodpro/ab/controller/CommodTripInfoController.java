package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodTripInfo;
import pers.mtx.commodpro.ab.service.ICommodTripInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 行程详情 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/commod-trip-info")
public class CommodTripInfoController {
    @Autowired
    private ICommodTripInfoService iCommodTripInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodTripInfo param) {
        return iCommodTripInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodTripInfo> param) {
        return iCommodTripInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodTripInfo param) {
        return iCommodTripInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodTripInfo> param) {
        return iCommodTripInfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodTripInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodTripInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodTripInfo param) {
        return iCommodTripInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodTripInfo> param) {
        return iCommodTripInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodTripInfo> listByIdList(@RequestBody List<String> param) {
        return iCommodTripInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodTripInfo getByid(@RequestParam("id") String id) {
        return iCommodTripInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodTripInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodTripInfo> stuPage = new Page<>(count,size);
        QueryWrapper<CommodTripInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodTripInfoService.page(stuPage,wrapper).getRecords();
    }


}
