package pers.mtx.comments_provider.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("comment_info")
public class CommentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "comments_id", type = IdType.ASSIGN_UUID)
    private String commentsId;

    /**
     * 商品id
     */
    @TableField("commod_id")
    private String commodId;

    /**
     * 评论状态
     */
    @TableField("comments_status")
    private Integer commentsStatus;

    /**
     * 评论人id
     */
    @TableField("comments_consumer_id")
    private String commentsConsumerId;

    /**
     * 评论类别
     */
    @TableField("comments_category")
    private Integer commentsCategory;

    /**
     * 评论星数
     */
    @TableField("comments_stars")
    private Integer commentsStars;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


}
