package pers.mtx.order_con;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/5 11:01
 **/
@SpringBootApplication
@EnableFeignClients
public class orderConApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderConApplication.class, args);
    }
}
