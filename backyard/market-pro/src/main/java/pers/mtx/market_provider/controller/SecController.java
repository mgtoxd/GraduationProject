package pers.mtx.market_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.market_provider.ab.entity.SecCommod;
import pers.mtx.market_provider.ab.service.ISecCommodService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 16:15
 **/
@RestController
@RequestMapping("/Sec")
public class SecController {
    @Autowired
    ISecCommodService secCommodService;

    @GetMapping("/getSecKByCommodId")
    public SecCommod getSecKByCommodId(@RequestParam("id") String id){
        return secCommodService.getOne(new QueryWrapper<SecCommod>().eq("com_id",id));
    }

    @GetMapping("/listSecCommodBySecId")
    public List<SecCommod> listSecCommodBySecId(@RequestParam("id") String id){
        return secCommodService.list(new QueryWrapper<SecCommod>().eq("sec_id", id));
    }
}
