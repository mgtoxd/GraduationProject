package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.AdminInfo;
import pers.mtx.auth_provider.ab.service.IAdminInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 管理员信息 前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-04-26
*/
    @RestController
@RequestMapping("/admin-info")
    public class AdminInfoController {
@Autowired
private IAdminInfoService iAdminInfoService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody AdminInfo param) {
return iAdminInfoService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<AdminInfo> param) {
return iAdminInfoService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody AdminInfo param) {
return iAdminInfoService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<AdminInfo> param) {
return iAdminInfoService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iAdminInfoService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iAdminInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody AdminInfo param) {
    return iAdminInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<AdminInfo> param) {
    return iAdminInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<AdminInfo> listByIdList(@RequestBody List<String> param) {
        return iAdminInfoService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  AdminInfo getByid(@RequestParam("id") String id) {
        return iAdminInfoService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<AdminInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<AdminInfo> stuPage = new Page<>(count,size);
        QueryWrapper<AdminInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iAdminInfoService.page(stuPage,wrapper).getRecords();
        }


        }
