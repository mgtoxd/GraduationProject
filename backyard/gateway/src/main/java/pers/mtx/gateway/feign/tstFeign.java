package pers.mtx.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mtx-order")
public interface tstFeign {
    @RequestMapping("/tst")
    String tst ();
}
