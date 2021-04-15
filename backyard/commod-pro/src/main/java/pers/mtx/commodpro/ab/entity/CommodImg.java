package pers.mtx.commodpro.ab.entity;

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
 * 商品图像表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commod_img")
public class CommodImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "commod_id", type = IdType.ASSIGN_UUID)
    private String commodId;

    /**
     * 图片url
     */
    @TableField("url")
    private String url;

    /**
     * 是否展示在外面界面
     */
    @TableField("is_index")
    private Boolean isIndex;

    /**
     * 是否展示在content轮播
     */
    @TableField("is_content")
    private Boolean isContent;

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