package pers.mtx.auth_consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.mtx.auth_consumer.entity.AdminAuth;
import pers.mtx.auth_consumer.entity.ConsumerAuth;

@FeignClient("auth-provider")
@RequestMapping("/login")
public interface LoginFeign {

    @PostMapping("/LoginByEmail")
    public String LoginByEmail(@RequestBody ConsumerAuth auth);
    @PostMapping("/LoginByPhoneNum")
    public String LoginByPhoneNum(@RequestBody ConsumerAuth auth);
    @PostMapping("/LoginAdmin")
    public String LoginAdmin(@RequestBody AdminAuth auth);
}