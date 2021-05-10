package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
 * <p>
 * 商品与店铺信息 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-store")
public interface CommodStoreControllerFeign {


    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodStore param);

    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodStore> param);

    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodStore param);

    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodStore> param);

    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodStore param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodStore> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommodStore> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  CommodStore getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<CommodStore> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
