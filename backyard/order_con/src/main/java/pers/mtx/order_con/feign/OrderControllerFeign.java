package pers.mtx.order_con.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.order_con.entity.OrderInfo;

import java.util.List;
@FeignClient("order-provider")
@RequestMapping("/order")
public interface OrderControllerFeign {

    @GetMapping("/listOrderInfoByConsumerId")
    public List<OrderInfo> listOrderInfoByConsumerId(@RequestParam("ConId") String ConId);
    @GetMapping("/getCountOrderStatusAndConsumerId")
    public Integer getCountOrderStatus(@RequestParam("status") Integer status,@RequestParam("ConsumerId") String ConId);
}
