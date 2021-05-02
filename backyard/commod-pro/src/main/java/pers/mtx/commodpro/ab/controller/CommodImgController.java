package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CommodImg;
import pers.mtx.commodpro.ab.service.ICommodImgService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品图像表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/commod-img")
public class CommodImgController {
    @Autowired
    private ICommodImgService iCommodImgService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodImg param) {
        return iCommodImgService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodImg> param) {
        return iCommodImgService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodImg param) {
        return iCommodImgService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodImg> param) {
        return iCommodImgService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCommodImgService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCommodImgService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodImg param) {
        return iCommodImgService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodImg> param) {
        return iCommodImgService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommodImg> listByIdList(@RequestBody List<String> param) {
        return iCommodImgService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CommodImg getByid(@RequestParam("id") String id) {
        return iCommodImgService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CommodImg> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommodImg> stuPage = new Page<>(count,size);
        QueryWrapper<CommodImg> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommodImgService.page(stuPage,wrapper).getRecords();
    }


}
