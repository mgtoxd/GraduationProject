package pers.mtx.order_con.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.mtx.order_con.entity.OrderInfo;


import java.util.List;

/**
 * <p>
 * 订单基本信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@FeignClient("order-provider")
@RequestMapping("/order-info")
public interface OrderInfoControllerFeign {

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody OrderInfo param);

    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<OrderInfo> param);

    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody OrderInfo param);

    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<OrderInfo> param);

    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody OrderInfo param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<OrderInfo> param);

    @PostMapping(value = "/listByIdList")
    public  List<OrderInfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  OrderInfo getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<OrderInfo> page(@RequestParam("count") Integer count, @RequestParam("size") Integer size);


}
