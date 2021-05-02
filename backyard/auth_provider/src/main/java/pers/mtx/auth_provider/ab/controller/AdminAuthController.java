package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.AdminAuth;
import pers.mtx.auth_provider.ab.service.IAdminAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 管理员认证 前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-04-26
*/
    @RestController
@RequestMapping("/admin-auth")
    public class AdminAuthController {
@Autowired
private IAdminAuthService iAdminAuthService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody AdminAuth param) {
return iAdminAuthService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<AdminAuth> param) {
return iAdminAuthService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody AdminAuth param) {
return iAdminAuthService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<AdminAuth> param) {
return iAdminAuthService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iAdminAuthService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iAdminAuthService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody AdminAuth param) {
    return iAdminAuthService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<AdminAuth> param) {
    return iAdminAuthService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<AdminAuth> listByIdList(@RequestBody List<String> param) {
        return iAdminAuthService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  AdminAuth getByid(@RequestParam("id") String id) {
        return iAdminAuthService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<AdminAuth> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<AdminAuth> stuPage = new Page<>(count,size);
        QueryWrapper<AdminAuth> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iAdminAuthService.page(stuPage,wrapper).getRecords();
        }


        }
