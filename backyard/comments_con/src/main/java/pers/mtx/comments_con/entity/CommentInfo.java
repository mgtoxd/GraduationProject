package pers.mtx.comments_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论基本信息表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */

    private String commentsId;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 评论状态
     */

    private Integer commentsStatus;

    /**
     * 评论人id
     */
    private String commentsConsumerId;

    /**
     * 评论类别
     */

    private Integer commentsCategory;

    /**
     * 评论星数
     */

    private Integer commentsStars;

    /**
     * 创建时间
     */

    private LocalDateTime createDate;

    /**
     * 更新时间
     */

    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */


    private Integer isDeleted;


}
