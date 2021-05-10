package pers.mtx.comments_con.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
* <p>
    * 评论基本信息表  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
import pers.mtx.comments_con.entity.*;
@FeignClient("comments-provider")
@RequestMapping("/comment-info")
    public interface CommentInfoControllerFeign {


@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentInfo param);

    @PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentInfo> param);

    @PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentInfo param);

    @PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentInfo> param);

    @GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentInfo param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentInfo> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommentInfo> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
        public  CommentInfo getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
        public List<CommentInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
