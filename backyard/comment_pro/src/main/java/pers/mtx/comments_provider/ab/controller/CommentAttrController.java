package pers.mtx.comments_provider.ab.controller;

import lombok.Data;
import pers.mtx.comments_provider.ab.entity.CommentAttr;
import pers.mtx.comments_provider.ab.service.ICommentAttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 评论特殊属性表  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
    @RestController
@RequestMapping("/comment-attr")
    public class CommentAttrController {
@Autowired
private ICommentAttrService iCommentAttrService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentAttr param) {
return iCommentAttrService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentAttr> param) {
return iCommentAttrService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentAttr param) {
return iCommentAttrService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentAttr> param) {
return iCommentAttrService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iCommentAttrService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iCommentAttrService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentAttr param) {
    return iCommentAttrService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentAttr> param) {
    return iCommentAttrService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommentAttr> listByIdList(@RequestBody List<String> param) {
        return iCommentAttrService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  CommentAttr getByid(@RequestParam("id") String id) {
        return iCommentAttrService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<CommentAttr> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommentAttr> stuPage = new Page<>(count,size);
        QueryWrapper<CommentAttr> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommentAttrService.page(stuPage,wrapper).getRecords();
        }


        }
