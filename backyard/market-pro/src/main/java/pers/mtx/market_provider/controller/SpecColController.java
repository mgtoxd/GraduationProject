package pers.mtx.market_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.market_provider.ab.entity.SpecColumnCommod;
import pers.mtx.market_provider.ab.service.ISpecColumnCommodService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/3 16:34
 **/
@RestController
@RequestMapping("/SpecColumn")
public class SpecColController {
    @Autowired
    ISpecColumnCommodService specColumnCommodService;

    @GetMapping("/listSpecColumnCommodBycommodId")
    public List<SpecColumnCommod> listSpecColumnCommodBycommodId(@RequestParam("id") String commodId) {
        return specColumnCommodService.list(new QueryWrapper<SpecColumnCommod>().eq("commod_id", commodId));
    }


    @GetMapping("/listBySpecColumnId")
    public List<SpecColumnCommod> listCommodIdBySpecColumnId(@RequestParam("id") String id) {
        return specColumnCommodService.list(new QueryWrapper<SpecColumnCommod>().eq("spec_column_id", id));
    }
}
