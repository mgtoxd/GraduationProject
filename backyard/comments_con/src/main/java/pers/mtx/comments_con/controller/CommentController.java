package pers.mtx.comments_con.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.mtx.comments_con.entity.CommentAttr;
import pers.mtx.comments_con.entity.CommentInfo;
import pers.mtx.comments_con.entity.CommentTxt;
import pers.mtx.comments_con.entity.ConsumerBaseInfo;
import pers.mtx.comments_con.feign.AuthProFeign;
import pers.mtx.comments_con.feign.CommentControllerFeign;
import pers.mtx.comments_con.feign.CommentInfoControllerFeign;
import pers.mtx.comments_con.feign.CommentTxtControllerFeign;
import pers.mtx.comments_con.result.RestResponse;
import pers.mtx.comments_con.vo.addCommentVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/6 11:07
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    AuthProFeign authProFeign;
    @Autowired
    Mapper dozerMapper;
    @Autowired
    CommentInfoControllerFeign commentInfoControllerFeign;
    @Autowired
    CommentTxtControllerFeign commentTxtControllerFeign;
    @Autowired
    CommentControllerFeign commentControllerFeign;

    @PostMapping("/addComment")
    public RestResponse addComment(HttpServletRequest request, @RequestBody addCommentVo vo){
        try {
            String token = request.getHeader("token");
            System.out.println(token);
            String consumerId = authProFeign.getConsumerBytoken(token);
            CommentInfo commentInfo = dozerMapper.map(vo, CommentInfo.class);
            commentInfo.setCommentsConsumerId(consumerId);
            String commentId = UUID.randomUUID().toString();
            commentInfo.setCommentsId(commentId);
            CommentTxt commentTxt = dozerMapper.map(vo, CommentTxt.class);
            commentTxt.setCommentsId(commentId);
            commentInfoControllerFeign.add(commentInfo);
            commentTxtControllerFeign.add(commentTxt);
        }catch (Exception e){
            return RestResponse.error(e.getMessage());
        }
        return RestResponse.success();
    }

    @GetMapping("/listByCommodId")
    public RestResponse listByCommodId(@RequestParam("id") String id){
        ArrayList<Object> result = new ArrayList<>();
        List<CommentInfo> commentInfoList = commentControllerFeign.listByCommodId(id);
        for (CommentInfo item :
                commentInfoList) {
            HashMap<String, Object> map = new HashMap<>();
            ConsumerBaseInfo baseInfoByid = authProFeign.getConsumerBaseInfoByid(item.getCommentsConsumerId());
            CommentTxt commentTxt = commentControllerFeign.txtByCommentId(item.getCommentsId());
            map.put("ConsumerInfo",baseInfoByid);
            map.put("commentsInfo",item);
            map.put("txt",commentTxt);
            result.add(map);
        }
        return RestResponse.success(result);
    }


}
