package pers.mtx.order_pro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.order_pro.ab.entity.OrderInfo;
import pers.mtx.order_pro.ab.service.IOrderInfoService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/5 19:28
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderInfoService orderInfoService;
    @GetMapping("/listOrderInfoByConsumerId")
    public List<OrderInfo> listOrderInfoByConsumerId(@RequestParam("ConId") String ConId){
        return orderInfoService.list(new QueryWrapper<OrderInfo>().eq("consumer_id", ConId));
    }

    @GetMapping("/getCountOrderStatusAndConsumerId")
    public Integer getCountOrderStatus(@RequestParam("status") Integer status,@RequestParam("ConsumerId") String ConId){
        return orderInfoService.count(new QueryWrapper<OrderInfo>().eq("order_stutas",status).eq("consumer_id",ConId));
    }
}
