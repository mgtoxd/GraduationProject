package pers.mtx.commodpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.commodpro.ab.entity.CalendarInfo;
import pers.mtx.commodpro.ab.service.ICalendarInfoService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/4 16:07
 **/
@RestController
@RequestMapping("/Calender")
public class CalenderController {
    @Autowired
    ICalendarInfoService calendarInfoService;


    /**
    * @Author: 马韬循
    * @Description: 通过年月获取日历信息
    * @DateTime: 19:51 2021/5/4
    * @Params: 
    * @Return 
    **/
    @GetMapping("/listByYearMon")
    public List<CalendarInfo> listByYearMon(@RequestParam("yearMon") String yearMon){
        return calendarInfoService.list(new QueryWrapper<CalendarInfo>().eq("year_mon", yearMon));
    }
}
