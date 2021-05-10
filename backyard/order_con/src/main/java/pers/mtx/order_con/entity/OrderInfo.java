package pers.mtx.order_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */

    private String id;

    /**
     * 订单商品id
     */

    private String commodId;

    /**
     * 订单状态
     */

    private Integer orderStutas;

    /**
     * 订单人数
     */

    private Integer orderMemCount;

    /**
     * 订单开始日期
     */

    private LocalDate bgDate;

    /**
     * 订单结束日期
     */

    private LocalDate overDate;

    /**
     * 订单提交人id
     */

    private String consumerId;

    /**
     * 订单价格
     */

    private Integer price;

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
