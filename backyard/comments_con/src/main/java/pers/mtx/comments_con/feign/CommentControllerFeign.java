package pers.mtx.comments_con.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/7 10:07
 **/
import pers.mtx.comments_con.entity.*;
@FeignClient("comments-provider")
@RequestMapping("/Comment")
public interface CommentControllerFeign {

    @GetMapping("/listByCommodId")
    public List<CommentInfo> listByCommodId(@RequestParam("id") String id);

    @GetMapping("/txtByCommentId")
    public CommentTxt txtByCommentId(@RequestParam("id") String id);
}
