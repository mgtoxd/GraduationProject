package pers.mtx.comments_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/6 11:12
 **/
@Data
@Accessors(chain = true)
public class addCommentVo {

    /**
     * 评论星数
     */

    private Integer commentsStars;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 评论内容
     */

    private String commentTxt;

}
