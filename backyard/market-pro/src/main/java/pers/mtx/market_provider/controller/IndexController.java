package pers.mtx.market_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.market_provider.ab.entity.IndexShowCommod;
import pers.mtx.market_provider.ab.service.IIndexShowCommodService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 16:15
 **/
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IIndexShowCommodService indexShowCommodService;

    @GetMapping("/getindexinfoByCommodId")
    public List<IndexShowCommod> getindexinfoByCommodId(@RequestParam("id") String id){
        return indexShowCommodService.list(new QueryWrapper<IndexShowCommod>().eq("commod_id", id));
    }

    @GetMapping("/removeIndexShowCommodByCommodId")
    public Boolean removeIndexShowCommodByCommodId(@RequestParam("id") String id){
        return indexShowCommodService.remove(new QueryWrapper<IndexShowCommod>().eq("commod_id", id));
    }
}
