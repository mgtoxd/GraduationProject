package pers.mtx.order_con.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.order_con.entity.CommodBasedinfo;
import pers.mtx.order_con.entity.OrderInfo;
import pers.mtx.order_con.feign.*;
import pers.mtx.order_con.result.RestResponse;
import pers.mtx.order_con.vo.BookCommod;
import pers.mtx.order_con.vo.SetCommod;
import pers.mtx.order_con.vo.addOrderVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/5 18:52
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderInfoControllerFeign orderInfoControllerFeign;

    @Autowired
    OrderControllerFeign orderControllerFeign;

    @Autowired
    AuthProFeign authProFeign;

    @Autowired
    CommodConFeign commodConFeign;

    @Autowired
    CommodProFeign commodProFeign;

    /**
    * @Author: 马韬循
    * @Description: 添加新订单
    * @DateTime: 18:53 2021/5/5
    * @Params:
    * @Return
    **/
    @PostMapping("/addOrder")
    public RestResponse addOrder(@RequestBody OrderInfo info){
        Boolean add = orderInfoControllerFeign.add(info);
        return add?RestResponse.success():RestResponse.error();
    }

    /**
    * @Author: 马韬循
    * @Description: 管理员账户获取订单列表
    * @DateTime: 19:16 2021/5/5
    * @Params:
    * @Return
    **/
    @GetMapping("/listOrderInfo")
    public RestResponse listOrderInfo(){
        List<OrderInfo> orderInfos = orderInfoControllerFeign.page(1, 1000);
        return RestResponse.success(orderInfos);
    }


    @GetMapping("/listOrderInfoBytoken")
    public RestResponse listOrderInfoBytoken(HttpServletRequest request){

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        String token = request.getHeader("token");
        System.out.println(token);
        String consumerId = authProFeign.getConsumerBytoken(token);
        System.out.println(consumerId);
        List<OrderInfo> orderInfoList = orderControllerFeign.listOrderInfoByConsumerId(consumerId);
        for (OrderInfo item :
                orderInfoList) {
            HashMap<String, Object> resultmap = new HashMap<>();
            CommodBasedinfo basedinfo = commodProFeign.getCommodBasedinfoByid(item.getCommodId());
            resultmap.put("orderInfo",item);
            resultmap.put("commodInfo",basedinfo);
            result.add(resultmap);
        }
        return RestResponse.success(result);
    }

    @GetMapping("/getOrderClassInfoBytoken")
    public RestResponse getOrderClassInfoBytoken(HttpServletRequest request){
        String token = request.getHeader("token");
        String consumerId = authProFeign.getConsumerBytoken(token);
        Integer weiZhiFu = orderControllerFeign.getCountOrderStatus(1, consumerId);
        Integer yzfwsy = orderControllerFeign.getCountOrderStatus(2, consumerId);
        Integer ysywpl = orderControllerFeign.getCountOrderStatus(3, consumerId);
        Integer bglyqx = orderControllerFeign.getCountOrderStatus(4, consumerId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("wzf",weiZhiFu);
        map.put("yzfwsy",yzfwsy);
        map.put("ysywpl",ysywpl);
        map.put("bglyqx",bglyqx);
        return RestResponse.success(map);
    }

    @PostMapping("/Book")
    public RestResponse Book(HttpServletRequest request, @RequestBody List<BookCommod> bookCommodList){
        String token = request.getHeader("token");
        String consumerId = authProFeign.getConsumerBytoken(token);
        StringBuilder builder = new StringBuilder();
        for (BookCommod item :
                bookCommodList) {
            if (item.getId()!=null){
                builder.append(item.getContent());
            }
        }
        String id = UUID.randomUUID().toString();
        commodProFeign.add(new CommodBasedinfo().setCommodId(id).setCommodName("定制商品"));
//        commodConFeign.setCommod(new SetCommod().setCommodId(id).setCommodDescription(builder.toString()).setCommodName("定制商品"));
        orderInfoControllerFeign.add(new OrderInfo().setCommodId(id).setConsumerId(consumerId).setOrderStutas(1));
        return RestResponse.success();
    }


    @GetMapping("/useOrder")
    public RestResponse useOrder(@RequestParam("id") String id){
        try {
            orderInfoControllerFeign.updateById(new OrderInfo().setId(id).setOrderStutas(3));
        }catch (Exception e){
            RestResponse.error(e.getMessage());
        }
        return RestResponse.success();
    }

    @GetMapping("/cancelOrder")
    public RestResponse cancelOrder(@RequestParam("id") String id){
        try {
            orderInfoControllerFeign.updateById(new OrderInfo().setId(id).setOrderStutas(4));
        }catch (Exception e){
            RestResponse.error(e.getMessage());
        }
        return RestResponse.success();
    }
    @GetMapping("/deleteOrder")
    public RestResponse deleteOrder(@RequestParam("id") String id){
        try {
            orderInfoControllerFeign.removeById(id);
        }catch (Exception e){
            RestResponse.error(e.getMessage());
        }
        return RestResponse.success();
    }
}
