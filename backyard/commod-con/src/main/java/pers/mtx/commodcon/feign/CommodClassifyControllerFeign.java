package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
 * <p>
 * 商品分类关联表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-classify")
public interface CommodClassifyControllerFeign {
    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodClassify param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodClassify> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodClassify param) ;
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodClassify> param);
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) ;
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodClassify param);
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodClassify> param);
    @PostMapping(value = "/listByIdList")
    public  List<CommodClassify> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  CommodClassify getByid(@RequestParam("id") String id) ;
    @GetMapping(value = "/pageByModify")
    public List<CommodClassify> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) ;


}
