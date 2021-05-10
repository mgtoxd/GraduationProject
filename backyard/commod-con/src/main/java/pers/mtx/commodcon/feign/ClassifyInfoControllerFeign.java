package pers.mtx.commodcon.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.mtx.commodcon.entity.*;



import java.util.List;

/**
 * <p>
 * 商品分类信息表 前端控制器
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@FeignClient("commod-provider")
@RequestMapping("/classify-info")
public interface ClassifyInfoControllerFeign {

    @PostMapping(value = "/add")
    public  Boolean add(@RequestBody ClassifyInfo param) ;
    @PostMapping(value = "/addList")
    public  Boolean addList(@RequestBody List<ClassifyInfo> param);
    @PostMapping(value = "/addOrUpdate")
    public  Boolean addOrUpdate(@RequestBody ClassifyInfo param) ;
    @PostMapping(value = "/addOrUpdateList")
    public  Boolean addOrUpdateList(@RequestBody List<ClassifyInfo> param);
    @GetMapping(value = "/removeById")
    public  Boolean removeById(@RequestParam("id") String id) ;
    @PostMapping(value = "/removeByIdList")
    public  Boolean removeByIdList(@RequestBody List<String> ids);
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ClassifyInfo param);
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ClassifyInfo> param);
    @PostMapping(value = "/listByIdList")
    public  List<ClassifyInfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
    public  ClassifyInfo getByid(@RequestParam("id") String id);
    @GetMapping(value = "/pageByModify")
    public List<ClassifyInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) ;

}
