package pers.mtx.commodcon.controller;

import com.github.dozermapper.core.Mapper;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodcon.entity.CalendarInfo;
import pers.mtx.commodcon.entity.CommodPrice;
import pers.mtx.commodcon.entity.CommodPriceDate;
import pers.mtx.commodcon.feign.CalenderFeign;
import pers.mtx.commodcon.feign.PriceFeign;
import pers.mtx.commodcon.result.RestResponse;
import pers.mtx.commodcon.vo.CalenderVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/4 15:14
 **/
@RestController
@RequestMapping("/Calendar")
public class CalendarController {
    @Autowired
    PriceFeign priceFeign;
    @Autowired
    CalenderFeign calenderFeign;
    @Autowired
    Mapper dozerMapper;

    @GetMapping("/listCalenderByCommodIdAndYearMon")
    public RestResponse listCalenderByCommodIdAndYearMon(@RequestParam("commodId") String commodId,@RequestParam("YearMon") String yearMon){
        ArrayList<CalenderVo> calenderVos = new ArrayList<>();
        List<CommodPriceDate> commodPrices = priceFeign.listDatePriceByCommodId(commodId);
        List<CalendarInfo> calendarInfos = calenderFeign.listByYearMon(yearMon);
        CommodPrice defaultPrice = priceFeign.getCommodPriceByid(commodId);
        for (CalendarInfo item :
                calendarInfos) {
            CalenderVo calenderVo = dozerMapper.map(item, CalenderVo.class);
            calenderVo.setPrice(findPrice(commodPrices,item,defaultPrice));
            if (!calenderVo.getPrice().equals(defaultPrice.getCommodPrice())){
                calenderVo.setSpecial(true);
            }else {
                calenderVo.setSpecial(false);
            }
            calenderVos.add(calenderVo);
        }
        return RestResponse.success(calenderVos);
    }

    public String findPrice(List<CommodPriceDate> commodPriceDates, CalendarInfo calendarInfo,CommodPrice defaultPrice){
        String day = "";
        if (calendarInfo.getDateInMon().trim().isEmpty()){
            return " ";
        }
        if (Integer.parseInt(calendarInfo.getDateInMon())<10){
            day = "-0"+calendarInfo.getDateInMon();
        }else {
            day = "-"+calendarInfo.getDateInMon();
        }
        for (CommodPriceDate item :
                commodPriceDates) {

            if (item.getCommodDateSpecial().equals(calendarInfo.getYearMon() + day)){

                return item.getCommodPriceSpecial();
            }
        }
        return defaultPrice.getCommodPrice();
    }

}
