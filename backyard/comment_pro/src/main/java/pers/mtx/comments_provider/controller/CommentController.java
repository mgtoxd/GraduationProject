package pers.mtx.comments_provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mtx.comments_provider.ab.entity.CommentInfo;
import pers.mtx.comments_provider.ab.entity.CommentTxt;
import pers.mtx.comments_provider.ab.service.ICommentInfoService;
import pers.mtx.comments_provider.ab.service.ICommentTxtService;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/7 10:07
 **/
@RestController
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    ICommentInfoService commentInfoService;
    @Autowired
    ICommentTxtService commentTxtService;
    @GetMapping("/listByCommodId")
    public List<CommentInfo> listByCommodId(@RequestParam("id") String id){
        List<CommentInfo> commentInfoList = commentInfoService.list(new QueryWrapper<CommentInfo>().eq("commod_id", id));
        return commentInfoList;
    }

    @GetMapping("/txtByCommentId")
    public CommentTxt txtByCommentId(@RequestParam("id") String id){
        return commentTxtService.getOne(new QueryWrapper<CommentTxt>().eq("comments_id",id));
    }
}
