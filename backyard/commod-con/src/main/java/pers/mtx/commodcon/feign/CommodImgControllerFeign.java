package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
 * <p>
 * 商品图像表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
import pers.mtx.commodcon.entity.*;

@FeignClient("commod-provider")
@RequestMapping("/commod-img")
public interface CommodImgControllerFeign {

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody CommodImg param);
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<CommodImg> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody CommodImg param);
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<CommodImg> param);
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) ;
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommodImg param);
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommodImg> param);
    @PostMapping(value = "/listByIdList")
    public  List<CommodImg> listByIdList(@RequestBody List<String> param) ;

    @GetMapping(value = "/getByid")
    public  CommodImg getByid(@RequestParam("id") String id) ;
    @GetMapping(value = "/pageByModify")
    public List<CommodImg> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
