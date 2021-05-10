package pers.mtx.commodcon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mtx.commodcon.entity.CalendarInfo;
import pers.mtx.commodcon.entity.ClassifyInfo;
import pers.mtx.commodcon.entity.CommodClassify;

import java.util.List;

@FeignClient("commod-provider")
//@Repository
public interface CalenderFeign {
    @GetMapping("/Calender/listByYearMon")
    public List<CalendarInfo> listByYearMon(@RequestParam("yearMon") String yearMon);

}
