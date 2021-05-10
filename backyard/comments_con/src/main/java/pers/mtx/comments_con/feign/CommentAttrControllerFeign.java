package pers.mtx.comments_con.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
* <p>
    * 评论特殊属性表  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
import pers.mtx.comments_con.entity.*;
@FeignClient("comments-provider")
@RequestMapping("/comment-attr")
    public interface CommentAttrControllerFeign {


@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentAttr param);

    @PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentAttr> param);

    @PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentAttr param);

    @PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentAttr> param);

    @GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentAttr param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentAttr> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommentAttr> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
        public  CommentAttr getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
        public List<CommentAttr> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
