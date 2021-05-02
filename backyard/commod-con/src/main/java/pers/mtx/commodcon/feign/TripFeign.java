package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.entity.CommodTripInfo;

import java.util.List;

@FeignClient("commod-provider")
//@Repository
public interface TripFeign {
    @PostMapping(value = "/trip/listByCommodId")
    public  List<CommodTripInfo> listCommodTripInfoByCommodId(@RequestBody String id);

    @GetMapping("/trip/removeByCommodId")
    public Boolean removeByCommodId(@RequestParam("id") String id);

    @PostMapping(value = "/commod-trip-info/addList")
    public  Boolean addCommodTripInfoList(@RequestBody List<CommodTripInfo> param);

}
