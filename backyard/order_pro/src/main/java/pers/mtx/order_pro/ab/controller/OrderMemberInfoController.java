package pers.mtx.order_pro.ab.controller;

import lombok.Data;
import pers.mtx.order_pro.ab.entity.OrderMemberInfo;
import pers.mtx.order_pro.ab.service.IOrderMemberInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单旅行者关联表  前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/order-member-info")
public class OrderMemberInfoController {
    @Autowired
    private IOrderMemberInfoService iOrderMemberInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody OrderMemberInfo param) {
        return iOrderMemberInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<OrderMemberInfo> param) {
        return iOrderMemberInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody OrderMemberInfo param) {
        return iOrderMemberInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<OrderMemberInfo> param) {
        return iOrderMemberInfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iOrderMemberInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iOrderMemberInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody OrderMemberInfo param) {
        return iOrderMemberInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<OrderMemberInfo> param) {
        return iOrderMemberInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<OrderMemberInfo> listByIdList(@RequestBody List<String> param) {
        return iOrderMemberInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  OrderMemberInfo getByid(@RequestParam("id") String id) {
        return iOrderMemberInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<OrderMemberInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<OrderMemberInfo> stuPage = new Page<>(count,size);
        QueryWrapper<OrderMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iOrderMemberInfoService.page(stuPage,wrapper).getRecords();
    }


}
