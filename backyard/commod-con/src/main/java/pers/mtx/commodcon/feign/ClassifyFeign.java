package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.mtx.commodcon.entity.ClassifyInfo;

@FeignClient("commod-provider")
//@Repository
public interface ClassifyFeign {
    @PostMapping(value = "/classify-info/add")
    public  Boolean add(@RequestBody ClassifyInfo param);
}
