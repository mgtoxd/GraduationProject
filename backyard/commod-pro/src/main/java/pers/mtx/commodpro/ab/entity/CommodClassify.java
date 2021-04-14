package pers.mtx.commodpro.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 商品分类关联表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commod_classify")
public class CommodClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableField("commod_id")
    private String commodId;

    /**
     * 分类id
     */
    @TableField("classify_id")
    private String classifyId;

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
