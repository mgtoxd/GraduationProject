package pers.mtx.commodcon;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommodConApplication {
 public static void main(String[] args) {
        SpringApplication.run(CommodConApplication.class, args);
    }
 }
