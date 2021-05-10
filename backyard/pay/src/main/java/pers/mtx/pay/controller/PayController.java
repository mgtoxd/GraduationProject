package pers.mtx.pay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.pay.entity.OrderInfo;
import pers.mtx.pay.feign.ClassifyFeign;
import pers.mtx.pay.util.AlipayConfig;
import pers.mtx.pay.vo.PayVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/6 12:57
 **/
@RestController
public class PayController {

    @Autowired
    ClassifyFeign feign;

    @PostMapping("/payy")
    public void pay(HttpServletRequest request, HttpServletResponse response, @RequestBody PayVo vo) throws IOException {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        // 付款金额，必填
        Integer total_amount = vo.getTotal_amount();
        // 订单名称，必填
        String subject = vo.getSubject();
        // 商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        feign.updateById(new OrderInfo().setId(vo.getOut_trade_no()).setOrderStutas(2));
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/get")
    public Object get(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getParameter("out_trade_no"));
        feign.updateById(new OrderInfo().setId(request.getParameter("out_trade_no")).setOrderStutas(2));
        return null;
    }

}
