package pers.mtx.order_con.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.order_con.entity.CommodBasedinfo;

@FeignClient("commod-provider")
public interface CommodProFeign {

    @GetMapping(value = "/commod-basedinfo/getByid")
    public CommodBasedinfo getCommodBasedinfoByid(@RequestParam("id") String id);
    @PostMapping(value = "/commod-basedinfo/add")
    public  Boolean add(@RequestBody CommodBasedinfo param);
}
