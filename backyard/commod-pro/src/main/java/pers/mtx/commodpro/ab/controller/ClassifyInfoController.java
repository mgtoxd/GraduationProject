package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.ClassifyInfo;
import pers.mtx.commodpro.ab.service.IClassifyInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品分类信息表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/classify-info")
public class ClassifyInfoController {
    @Autowired
    private IClassifyInfoService iClassifyInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ClassifyInfo param) {
        return iClassifyInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ClassifyInfo> param) {
        return iClassifyInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ClassifyInfo param) {
        return iClassifyInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ClassifyInfo> param) {
        return iClassifyInfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iClassifyInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iClassifyInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ClassifyInfo param) {
        return iClassifyInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ClassifyInfo> param) {
        return iClassifyInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ClassifyInfo> listByIdList(@RequestBody List<String> param) {
        return iClassifyInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  ClassifyInfo getByid(@RequestParam("id") String id) {
        return iClassifyInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<ClassifyInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ClassifyInfo> stuPage = new Page<>(count,size);
        QueryWrapper<ClassifyInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iClassifyInfoService.page(stuPage,wrapper).getRecords();
    }


}
