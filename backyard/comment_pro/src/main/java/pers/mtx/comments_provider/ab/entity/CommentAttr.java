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
 * 评论特殊属性表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment_attr")
public class CommentAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_attr_id", type = IdType.ASSIGN_UUID)
    private String commentAttrId;

    /**
     * 评论id
     */
    @TableField("comments_id")
    private String commentsId;

    /**
     * 特殊属性名称
     */
    @TableField("comments_attr_name")
    private String commentsAttrName;

    /**
     * 特殊属性值
     */
    @TableField("comments_attr_value")
    private String commentsAttrValue;

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
