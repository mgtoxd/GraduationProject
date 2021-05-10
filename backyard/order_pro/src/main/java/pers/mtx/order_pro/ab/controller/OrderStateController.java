package pers.mtx.order_pro.ab.controller;

import lombok.Data;
import pers.mtx.order_pro.ab.entity.OrderState;
import pers.mtx.order_pro.ab.service.IOrderStateService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单状态表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/order-state")
public class OrderStateController {
    @Autowired
    private IOrderStateService iOrderStateService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody OrderState param) {
        return iOrderStateService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<OrderState> param) {
        return iOrderStateService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody OrderState param) {
        return iOrderStateService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<OrderState> param) {
        return iOrderStateService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iOrderStateService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iOrderStateService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody OrderState param) {
        return iOrderStateService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<OrderState> param) {
        return iOrderStateService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<OrderState> listByIdList(@RequestBody List<String> param) {
        return iOrderStateService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  OrderState getByid(@RequestParam("id") String id) {
        return iOrderStateService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<OrderState> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<OrderState> stuPage = new Page<>(count,size);
        QueryWrapper<OrderState> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iOrderStateService.page(stuPage,wrapper).getRecords();
    }


}
