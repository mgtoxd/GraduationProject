package pers.mtx.market_provider.ab.entity;

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
 * 专栏管理表
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("spec_column")
public class SpecColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专栏id
     */
    @TableId(value = "spec_column_id", type = IdType.ASSIGN_UUID)
    private String specColumnId;

    /**
     * 专栏名称
     */
    @TableField("spec_column_title")
    private String specColumnTitle;

    /**
     * 专栏图片
     */
    @TableField("spec_column_img_url")
    private String specColumnImgUrl;

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
