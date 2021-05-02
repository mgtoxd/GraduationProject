package pers.mtx.market_provider.ab.controller;

import lombok.Data;
import pers.mtx.market_provider.ab.entity.IndexPos;
import pers.mtx.market_provider.ab.service.IIndexPosService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页位置标识表  前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-02
 */
@RestController
@RequestMapping("/index-pos")
public class IndexPosController {
    @Autowired
    private IIndexPosService iIndexPosService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody IndexPos param) {
        return iIndexPosService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<IndexPos> param) {
        return iIndexPosService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody IndexPos param) {
        return iIndexPosService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<IndexPos> param) {
        return iIndexPosService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iIndexPosService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iIndexPosService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody IndexPos param) {
        return iIndexPosService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<IndexPos> param) {
        return iIndexPosService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<IndexPos> listByIdList(@RequestBody List<String> param) {
        return iIndexPosService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  IndexPos getByid(@RequestParam("id") String id) {
        return iIndexPosService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<IndexPos> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<IndexPos> stuPage = new Page<>(count,size);
        QueryWrapper<IndexPos> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iIndexPosService.page(stuPage,wrapper).getRecords();
    }


}
