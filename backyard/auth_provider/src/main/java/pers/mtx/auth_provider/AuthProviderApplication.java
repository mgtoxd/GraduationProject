package pers.mtx.auth_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class AuthProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthProviderApplication.class, args);
    }

//    @Bean
//    public RedisTemplate redisTemplate(){
//        return new RedisTemplate();
//    }
}
