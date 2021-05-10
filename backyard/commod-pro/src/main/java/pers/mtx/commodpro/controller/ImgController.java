package pers.mtx.commodpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodpro.ab.entity.CommodImg;
import pers.mtx.commodpro.ab.service.ICommodImgService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/4 19:51
 **/
@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    ICommodImgService commodImgService;
    @GetMapping("/getContentImgByCommodId")
    public List<CommodImg> getImgByCommodId(@RequestParam("commodId") String id){
        return commodImgService.list(new QueryWrapper<CommodImg>().eq("commod_id", id).eq("is_content", 1));
    }
}
