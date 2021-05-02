package pers.mtx.commodcon.controller;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;
import pers.mtx.commodcon.entity.CommodPrice;
import pers.mtx.commodcon.entity.CommodPriceDate;
import pers.mtx.commodcon.feign.ClassifyFeign;
import pers.mtx.commodcon.feign.PriceFeign;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.setClassifyVo;
import pers.mtx.commodcon.vo.setPriceVo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description: 价格控制器
 * @DateTime: 2021/4/14 20:12
 **/
@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    PriceFeign priceFeign;
    @Autowired
    Mapper dozerMapper;

    /**
    * @Author: 马韬循
    * @Description: 根据商品id获取全部价格信息
    * @DateTime: 8:59 2021/4/30
    * @Params:
    * @Return
    **/
    @GetMapping("/getPriceByCommodId")
    public RestResponse getPriceByCommodId(@RequestParam("id") String id){

        List<CommodPriceDate> commodPriceDates = priceFeign.listDatePriceByCommodId(id);
        HashMap<String, Object> result = new HashMap<>();
        result.put("DatePriceList",commodPriceDates);
        result.put("Price",priceFeign.getCommodPriceByid(id));
        return RestResponse.success(result);
    }


    /**
    * @Author: 马韬循
    * @Description: 设置商品的价格
    * @DateTime: 9:47 2021/4/30
    * @Params: 
    * @Return 
    **/
    @PostMapping("/setCommodPriceDate")
    public RestResponse setCommodPriceDate(@RequestBody setPriceVo priceVo){
        CommodPrice commodPrice = dozerMapper.map(priceVo, CommodPrice.class);
        priceFeign.removeDatePriceByCommodId(priceVo.getCommodId());
        if (priceFeign.updateCommodPriceById(commodPrice)&&  priceFeign.addCommodPriceDateList(priceVo.getCommodPriceDateList())){
            return RestResponse.success();
        }
        return RestResponse.error();



    }
}
