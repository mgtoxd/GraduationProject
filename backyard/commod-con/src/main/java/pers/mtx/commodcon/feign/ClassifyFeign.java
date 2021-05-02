package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;

import java.util.List;

@FeignClient("commod-provider")
//@Repository
public interface ClassifyFeign {
    @PostMapping(value = "/classify-info/add")
    public  Boolean add(@RequestBody ClassifyInfo param);
    @GetMapping(value = "/classify-info/pageByModify")
    public List<ClassifyInfo> pageClassifyInfo(@RequestParam("count") Integer count, @RequestParam("size") Integer size);
    @GetMapping("/classify/listByCommodId")
    public List<CommodClassify> listByCommodId(@RequestParam("id") String id);
    @GetMapping("/classify/removeByCommodId")
    public Boolean removeByCommodId(@RequestParam("id") String id);
    @PostMapping(value = "/commod-classify/add")
    public  Boolean addCommodClassify(@RequestBody CommodClassify param);

}
