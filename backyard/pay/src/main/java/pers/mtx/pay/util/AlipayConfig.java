package pers.mtx.pay.util;

import lombok.Data;


public class AlipayConfig {
    // 应用ID,您的APPID,收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000117649706";
    // 商户私钥，
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCv6S2zNkZ3PJ44fUJXiK+RThC91kuaZJVAsJ8quchcXUXOXFA1bdk6zwiQEOIhy4nikPzmDao+pBizzZmcjo5r6evhWtFiPaX2txRwvNivTfHGi37u4+tw/7aYAZ+gIvS6P0zcVZV13rHObShhsAnwHzACl+qgac3yPfxnPcjiVLMnIJ0vU/nm2QFM39MvDEBmB4l5B3hYcvwwuQX158emkxaBU/Ia66RVpLG6zVjg7gp7pRkPHOH/hNlLPYFsdS7lqdL3UEqUO1BulhExEzayOjbt6Y6KUWwo0Y7+UEO67Vr4oSnzcHyZLoDMBFlqeucw/5ptAYnFSDMAO0R47Z51AgMBAAECggEAZE0Yea7gzuwJazxAr5iIQtm4QgYGZaokUBZlKv9zdvbX7qpEMbLIwfd6cmquBYcAv+bbzHDOOZlnXF5G0DWYj395t60I5nMwRlRtmzqScqKG0SaI4b2jaXLkshd65NwJnoipUpiZ9/NaftFOzSSLBhdCULg+V+j8PLuLR3K7MBEVrmKReI7cl9YhBF4R1bU4JeKAIvxFBmpidBJsDLEghC/L+KgzGef2epROo7o5SV6VNZGbKii2kkGLC2g+wrtNxM8+wEwh8/e+oOKoRXKGhqNpECdK1/Qj0AMy7h0QGxRy4DBpEmDXaI4XENkZrN9AfwJg6zz7YS0wn65HVvk4AQKBgQD9KncSO3Z8jPzCCp4t32ttrGQD4YDXGp4xO6ryRnEM1CFDphcPNT866uEdLNv/ho5X/ceolwRriDSVbXvdi9Vf29Vs6yOgaFbqmpcZ2Gd+kKJ97hsTmtS9c6r1qOH6LGcnx4kVAHqsdkY57OTClV2lIgoy5jD5bqtYCY4ju7UeNQKBgQCx4U/vgCq7Lm9lYwltRe8Z5a9RmRXIoPrSh/UHlEyaVyDfrY4/c1Offk+MDyuE2DW5spjDF1YBUyQACXghTv1qFaIr9MCgTj57QMcOTzmV3o0lp9cQc73SP5kftauuumSQHITrHN+2wGIBDkFxMckJ8uDMONb8Ubsmnh3tBVeHQQKBgQCYcYSnluS/FQpyMYCUMM94h/DloVk6rY2KKdrC7oXOasHpAU8rWi3L5XlOXx/OGxEFjQw3yU/hDHBVdkq62iPPCAnY/zJBufJ0bEgGSRfwz1j5KXJmeLoXplnQeTQxt6EaA/3YhqRXyxR4dtw9C0ILWJb5lUDyQaCtb3uGqtXh7QKBgQCW4c1SE98rIvouf9ExNU7ZIrCRgE6v/YyEI/q90RchG6Kw2KB+Ra667QNAhGWfq133A/z8DsFPIly5A084wa3G3E7RBiyWTYhGN+4gvybTbxE+zZ1pQSPUQUn7Ubgs38IJU4eTfsxsUcdPqe3svBQRMkloMRZ6tEERQrGTqSJTgQKBgEctYPH0lDdiM/YCTAL/RZMYlXJ/gN4K0uF3Do8DwuxKVzuXQWnu6ntOXRnOa89PlkTD4ABiEfrRBYMq4i9mNexome3T2myMapGLT+83nz7MEfEROSUvw4YFL9hgoN5bc5keY27bbdWYhC/Aqp9amgutn2kQsh9LB/xENSfl+qjB";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjq9wh0E8IFQv4K+rPPyAyi6OybHyIaORkj0ZeKLMQrux12rdNCuziIOzO1OytfQCzHtTKJmaJTgdFofZXfuCwMqVD17soqfhrpl7fbmowR5zu0hQgFvzbi741Ev4h7ePzxTgn669JHh1sbdRG56dSJ8gWzsm7vUczgQCfYyKYTPMZ42IrygilNDha7PJyIzpBMD9WIBCRFMbhoNPoAstGBhKQhuWVM2/rl1Z0nxrQbtY8+ugZtLFHT0jXDNB1xXWTQLbQAL7HHV87Erl+4UpnAJiYEdRu2Hn5iicKacNYoeyDt/jn6T9gH6eFTavhy5TPagsA1mGljPr3/FfFR/2OwIDAQAB";
    // 服务器异步通知页面路径,需http://格式的完整路径，不能加自定义参数，必须外网可以正常访问
    public static String notify_url = "http://getpayback.cn1.utools.club/pay/pay/get";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能自定义参数，支付成功后返回的页面
    public static String return_url = "http://mtxcode1024.cn.utools.club";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String CHARSET = "utf-8";
    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    // public static String log_path = "https://openapi.alipay.com/gateway.do";
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}
