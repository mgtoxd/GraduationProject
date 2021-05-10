package pers.mtx.comments_con.feign;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



import java.util.List;

/**
* <p>
    * 评论内容  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
import pers.mtx.comments_con.entity.*;
@FeignClient("comments-provider")
@RequestMapping("/comment-txt")
    public interface CommentTxtControllerFeign {

@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentTxt param);

    @PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentTxt> param);

    @PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentTxt param);

    @PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentTxt> param);

    @GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id);

    @PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids);

    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentTxt param);

    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentTxt> param);

    @PostMapping(value = "/listByIdList")
    public  List<CommentTxt> listByIdList(@RequestBody List<String> param);

    @GetMapping(value = "/getByid")
        public  CommentTxt getByid(@RequestParam("id") String id);

    @GetMapping(value = "/pageByModify")
        public List<CommentTxt> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size);


}
