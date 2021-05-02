package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.IndexShowCommod;
import pers.mtx.market_provider.ab.service.IIndexShowCommodService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页展示商品表  前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-02
 */
@RestController
@RequestMapping("/index-show-commod")
public class IndexShowCommodController {
    @Autowired
    private IIndexShowCommodService iIndexShowCommodService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody IndexShowCommod param) {
        return iIndexShowCommodService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<IndexShowCommod> param) {
        return iIndexShowCommodService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody IndexShowCommod param) {
        return iIndexShowCommodService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<IndexShowCommod> param) {
        return iIndexShowCommodService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iIndexShowCommodService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iIndexShowCommodService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody IndexShowCommod param) {
        return iIndexShowCommodService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<IndexShowCommod> param) {
        return iIndexShowCommodService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<IndexShowCommod> listByIdList(@RequestBody List<String> param) {
        return iIndexShowCommodService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  IndexShowCommod getByid(@RequestParam("id") String id) {
        return iIndexShowCommodService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<IndexShowCommod> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<IndexShowCommod> stuPage = new Page<>(count,size);
        QueryWrapper<IndexShowCommod> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iIndexShowCommodService.page(stuPage,wrapper).getRecords();
    }


}
