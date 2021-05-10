package pers.mtx.comments_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论内容 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommentTxt implements Serializable {

    private static final long serialVersionUID = 1L;


    private String commentTxtId;

    /**
     * 评论id
     */

    private String commentsId;

    /**
     * 评论内容
     */

    private String commentTxt;

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
