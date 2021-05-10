package pers.mtx.commodpro.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
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
 * 商品库存表
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commod_sku")
public class CommodSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableField("commod_id")
    private String commodId;

    /**
     * 日期
     */
    @TableField("date")
    private LocalDate date;

    /**
     * 库存
     */
    @TableField("stock")
    private Long stock;

    /**
     * 最低库存
     */
    @TableField("Low_stock")
    private String lowStock;

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
