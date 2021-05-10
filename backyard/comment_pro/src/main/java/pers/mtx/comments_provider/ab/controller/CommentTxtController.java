package pers.mtx.comments_provider.ab.controller;

import lombok.Data;
import pers.mtx.comments_provider.ab.entity.CommentTxt;
import pers.mtx.comments_provider.ab.service.ICommentTxtService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 评论内容  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
    @RestController
@RequestMapping("/comment-txt")
    public class CommentTxtController {
@Autowired
private ICommentTxtService iCommentTxtService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentTxt param) {
return iCommentTxtService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentTxt> param) {
return iCommentTxtService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentTxt param) {
return iCommentTxtService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentTxt> param) {
return iCommentTxtService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iCommentTxtService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iCommentTxtService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentTxt param) {
    return iCommentTxtService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentTxt> param) {
    return iCommentTxtService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommentTxt> listByIdList(@RequestBody List<String> param) {
        return iCommentTxtService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  CommentTxt getByid(@RequestParam("id") String id) {
        return iCommentTxtService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<CommentTxt> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommentTxt> stuPage = new Page<>(count,size);
        QueryWrapper<CommentTxt> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommentTxtService.page(stuPage,wrapper).getRecords();
        }


        }
