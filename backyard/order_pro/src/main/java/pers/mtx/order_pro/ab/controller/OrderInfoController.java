package pers.mtx.order_pro.ab.controller;

import lombok.Data;
import pers.mtx.order_pro.ab.entity.OrderInfo;
import pers.mtx.order_pro.ab.service.IOrderInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单基本信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService iOrderInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody OrderInfo param) {
        return iOrderInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<OrderInfo> param) {
        return iOrderInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody OrderInfo param) {
        return iOrderInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<OrderInfo> param) {
        return iOrderInfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iOrderInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iOrderInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody OrderInfo param) {
        return iOrderInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<OrderInfo> param) {
        return iOrderInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<OrderInfo> listByIdList(@RequestBody List<String> param) {
        return iOrderInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  OrderInfo getByid(@RequestParam("id") String id) {
        return iOrderInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<OrderInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<OrderInfo> stuPage = new Page<>(count,size);
        QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iOrderInfoService.page(stuPage,wrapper).getRecords();
    }


}
