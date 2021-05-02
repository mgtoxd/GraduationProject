package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.entity.CommodPrice;
import pers.mtx.commodcon.entity.CommodPriceDate;

import java.util.List;

@FeignClient("commod-provider")
public interface PriceFeign {

    @GetMapping(value = "/commod-price/getByid")
    public CommodPrice getCommodPriceByid(@RequestParam("id") String id);

    @GetMapping("/price/listDatePriceByCommodId")
    public List<CommodPriceDate> listDatePriceByCommodId(@RequestParam("id") String id);

    @PostMapping(value = "/commod-price/updateById")
    public  Boolean updateCommodPriceById(@RequestBody CommodPrice param);

    @GetMapping("/price/removeDatePriceByCommodId")
    public Boolean removeDatePriceByCommodId(@RequestParam("id") String id);

    @PostMapping(value = "/commod-price-date/addList")
    public  Boolean addCommodPriceDateList(@RequestBody List<CommodPriceDate> param);

}
