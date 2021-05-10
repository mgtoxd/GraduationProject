package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
 * <p>
 * 行程详情 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-trip-info")
public interface CommodTripInfoControllerFeign {


    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodTripInfo param);

    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodTripInfo> param);

    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodTripInfo param);

    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodTripInfo> param);

    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodTripInfo param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodTripInfo> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommodTripInfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  CommodTripInfo getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<CommodTripInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
