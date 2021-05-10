package pers.mtx.comments_provider.ab.controller;

import lombok.Data;
import pers.mtx.comments_provider.ab.entity.CommentInfo;
import pers.mtx.comments_provider.ab.service.ICommentInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 评论基本信息表  前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-05-06
*/
    @RestController
@RequestMapping("/comment-info")
    public class CommentInfoController {
@Autowired
private ICommentInfoService iCommentInfoService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody CommentInfo param) {
return iCommentInfoService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<CommentInfo> param) {
return iCommentInfoService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody CommentInfo param) {
return iCommentInfoService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<CommentInfo> param) {
return iCommentInfoService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iCommentInfoService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iCommentInfoService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody CommentInfo param) {
    return iCommentInfoService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<CommentInfo> param) {
    return iCommentInfoService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<CommentInfo> listByIdList(@RequestBody List<String> param) {
        return iCommentInfoService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  CommentInfo getByid(@RequestParam("id") String id) {
        return iCommentInfoService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<CommentInfo> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<CommentInfo> stuPage = new Page<>(count,size);
        QueryWrapper<CommentInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iCommentInfoService.page(stuPage,wrapper).getRecords();
        }


        }
