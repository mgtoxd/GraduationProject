package pers.mtx.market_con;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/25 15:41
 **/
@SpringBootApplication
@EnableFeignClients
public class MarketConApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketConApplication.class, args);
    }
}
