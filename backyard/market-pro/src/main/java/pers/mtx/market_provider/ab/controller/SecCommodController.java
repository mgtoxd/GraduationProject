package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.SecCommod;
import pers.mtx.market_provider.ab.service.ISecCommodService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 秒杀商品表  前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/sec-commod")
public class SecCommodController {
    @Autowired
    private ISecCommodService iSecCommodService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody SecCommod param) {
        return iSecCommodService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<SecCommod> param) {
        return iSecCommodService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody SecCommod param) {
        return iSecCommodService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<SecCommod> param) {
        return iSecCommodService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iSecCommodService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iSecCommodService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody SecCommod param) {
        return iSecCommodService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<SecCommod> param) {
        return iSecCommodService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<SecCommod> listByIdList(@RequestBody List<String> param) {
        return iSecCommodService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  SecCommod getByid(@RequestParam("id") String id) {
        return iSecCommodService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<SecCommod> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<SecCommod> stuPage = new Page<>(count,size);
        QueryWrapper<SecCommod> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iSecCommodService.page(stuPage,wrapper).getRecords();
    }


}
