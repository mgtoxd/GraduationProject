package pers.mtx.commodpro.ab.controller;

import lombok.Data;
import pers.mtx.commodpro.ab.entity.CalendarInfo;
import pers.mtx.commodpro.ab.service.ICalendarInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 日历信息表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/calendar-info")
public class CalendarInfoController {
    @Autowired
    private ICalendarInfoService iCalendarInfoService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CalendarInfo param) {
        return iCalendarInfoService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CalendarInfo> param) {
        return iCalendarInfoService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CalendarInfo param) {
        return iCalendarInfoService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CalendarInfo> param) {
        return iCalendarInfoService.saveOrUpdateBatch(param);
    }
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iCalendarInfoService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iCalendarInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CalendarInfo param) {
        return iCalendarInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CalendarInfo> param) {
        return iCalendarInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CalendarInfo> listByIdList(@RequestBody List<String> param) {
        return iCalendarInfoService.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  CalendarInfo getByid(@RequestParam("id") String id) {
        return iCalendarInfoService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<CalendarInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CalendarInfo> stuPage = new Page<>(count,size);
        QueryWrapper<CalendarInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCalendarInfoService.page(stuPage,wrapper).getRecords();
    }


}
