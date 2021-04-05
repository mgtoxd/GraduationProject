package ${package.Controller};

import lombok.Data;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ${entity} param) {
        return ${table.serviceName?uncap_first}.save(param);
    }
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<${entity}> param) {
        return ${table.serviceName?uncap_first}.saveBatch(param);
    }
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ${entity} param) {
        return ${table.serviceName?uncap_first}.saveOrUpdate(param);
    }
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<${entity}> param) {
        return ${table.serviceName?uncap_first}.saveOrUpdateBatch(param);
    }
    @PostMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) {
        return ${table.serviceName?uncap_first}.removeById(id);
    }
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids) {
        return ${table.serviceName?uncap_first}.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ${entity} param) {
        return ${table.serviceName?uncap_first}.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<${entity}> param) {
        return ${table.serviceName?uncap_first}.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<${entity}> listByIdList(@RequestBody List<String> param) {
        return ${table.serviceName?uncap_first}.listByIds(param);
    }

    @GetMapping(value = "/getByid")
    public  ${entity} getByid(@RequestParam("id") String id) {
        return ${table.serviceName?uncap_first}.getById(id);
    }
    @GetMapping(value = "/pageByModify")
    public List<${entity}> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<${entity}> stuPage = new Page<>(count,size);
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return ${table.serviceName?uncap_first}.page(stuPage,wrapper).getRecords();
    }


}
</#if>
