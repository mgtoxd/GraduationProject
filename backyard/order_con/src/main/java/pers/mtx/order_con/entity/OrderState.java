package pers.mtx.order_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单状态表
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class OrderState implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态id
     */

    private Integer stateId;

    /**
     * 状态名称
     */

    private String stateName;

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
