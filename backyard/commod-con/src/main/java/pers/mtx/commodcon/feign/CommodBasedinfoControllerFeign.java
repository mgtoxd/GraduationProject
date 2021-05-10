package pers.mtx.commodcon.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 * 商品基础信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-basedinfo")
public interface CommodBasedinfoControllerFeign {


    @PostMapping(value = "/add")
    public Boolean add(@RequestBody CommodBasedinfo param);

    @PostMapping(value = "/addList")
    public Boolean addList(@RequestBody List<CommodBasedinfo> param);

    @PostMapping(value = "/addOrUpdate")
    public Boolean addOrUpdate(@RequestBody CommodBasedinfo param);

    @PostMapping(value = "/addOrUpdateList")
    public Boolean addOrUpdateList(@RequestBody List<CommodBasedinfo> param);

    @GetMapping(value = "/removeById")
    public Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
    public Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public Boolean updateById(@RequestBody CommodBasedinfo param);

    @PostMapping(value = "/updateListById")
    public Boolean updateBatchById(@RequestBody List<CommodBasedinfo> param);

    @PostMapping(value = "/listByIdList")
    public List<CommodBasedinfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public CommodBasedinfo getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<CommodBasedinfo> page(@RequestParam("count") Integer count, @RequestParam("size") Integer size);

}
