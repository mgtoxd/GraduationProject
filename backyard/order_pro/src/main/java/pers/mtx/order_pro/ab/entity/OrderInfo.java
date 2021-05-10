package pers.mtx.order_pro.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * 订单基本信息
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 订单商品id
     */
    @TableField("commod_id")
    private String commodId;

    /**
     * 订单状态
     */
    @TableField("order_stutas")
    private Integer orderStutas;

    /**
     * 订单人数
     */
    @TableField("order_mem_count")
    private Integer orderMemCount;

    /**
     * 订单开始日期
     */
    @TableField("bg_date")
    private LocalDate bgDate;

    /**
     * 订单结束日期
     */
    @TableField("over_date")
    private LocalDate overDate;

    /**
     * 订单提交人id
     */
    @TableField("consumer_id")
    private String consumerId;

    /**
     * 订单价格
     */
    @TableField("price")
    private Integer price;

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
