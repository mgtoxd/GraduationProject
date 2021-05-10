package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.*;

import java.util.List;

@FeignClient("commod-provider")
public interface CommodFeign {


    @PostMapping(value = "/commod-basedinfo/add")
    public  Boolean addCommodBasedinfo(@RequestBody CommodBasedinfo param);

    @PostMapping(value = "/commod-price/add")
    public  Boolean addCommodPrice(@RequestBody CommodPrice param);

    @PostMapping(value = "/commod-txt/add")
    public  Boolean addCommodTxt(@RequestBody CommodTxt param);

    @PostMapping(value = "/commod-trip-info/addList")
    public  Boolean addListCommodTripInfo(@RequestBody List<CommodTripInfo> param);

    @PostMapping(value = "/commod-img/add")
    public  Boolean addCommodImg(@RequestBody CommodImg param);

    @PostMapping(value = "/commod-classify/add")
    public  Boolean addCommodClassify(@RequestBody CommodClassify param);

    @PostMapping(value = "/commod-sku/add")
    public  Boolean addCommodSku(@RequestBody CommodSku param);

    @GetMapping(value = "/commod-basedinfo/pageByModify")
    public List<CommodBasedinfo> pageCommodBasedinfo(@RequestParam("count") Integer count,@RequestParam("size") Integer size);

    @GetMapping("/count/CommodBasedinfo")
    public Integer CountCommodBasedinfo();

    @GetMapping(value = "/commod-basedinfo/removeById")
    public  Boolean removeCommodBaseinfoById(@RequestParam("id") String id);


    @GetMapping("/img/getContentImgByCommodId")
    public List<CommodImg> getContentImgByCommodId(@RequestParam("commodId") String id);
}
