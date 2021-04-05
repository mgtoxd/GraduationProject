package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.BusinessmanAuth;
import pers.mtx.auth_provider.ab.service.IBusinessmanAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商铺管理者认证 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/businessman-auth")
public class BusinessmanAuthController {
    @Autowired
    private IBusinessmanAuthService iBusinessmanAuthService;

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody BusinessmanAuth param) {
        return iBusinessmanAuthService.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<BusinessmanAuth> param) {
        return iBusinessmanAuthService.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody BusinessmanAuth param) {
        return iBusinessmanAuthService.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<BusinessmanAuth> param) {
        return iBusinessmanAuthService.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return iBusinessmanAuthService.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return iBusinessmanAuthService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody BusinessmanAuth param) {
        return iBusinessmanAuthService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<BusinessmanAuth> param) {
        return iBusinessmanAuthService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<BusinessmanAuth> listByIdList(@RequestBody List<String> param) {
        return iBusinessmanAuthService.listByIds(param);
    }

    @PostMapping(value = "/getByid")
    public  BusinessmanAuth getByid(@RequestParam("id") String id) {
        return iBusinessmanAuthService.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<BusinessmanAuth> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<BusinessmanAuth> stuPage = new Page<>(count,size);
        QueryWrapper<BusinessmanAuth> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iBusinessmanAuthService.page(stuPage,wrapper).getRecords();
    }


}
