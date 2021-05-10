package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
 * <p>
 * 商品库存表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-sku")
public interface CommodSkuControllerFeign {

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodSku param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodSku> param) ;
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodSku param);
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodSku> param);
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id);
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodSku param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodSku> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommodSku> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  CommodSku getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
    public List<CommodSku> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
