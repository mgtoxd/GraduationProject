package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.entity.CommodSku;

import java.util.List;

@FeignClient("commod-provider")
public interface SkuFeign {
    @PostMapping(value = "/commod-sku/listByIdList")
    public  List<CommodSku> listCommodSkuByIdList(@RequestBody List<String> param);

    @PostMapping(value = "/commod-sku/addList")
    public  Boolean addCommodSkuList(@RequestBody List<CommodSku> param);

    @GetMapping(value = "/commod-sku/removeById")
    public  Boolean removeCommodSkuById(@RequestParam("id") String id);
}
