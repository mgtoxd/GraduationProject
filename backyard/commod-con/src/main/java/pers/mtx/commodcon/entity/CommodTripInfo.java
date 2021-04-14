package pers.mtx.commodcon.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 行程详情
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommodTripInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 行程景点名称
     */

    private String commodTripLocation;

    /**
     * 行程景点描述
     */

    private String commodTripDescribe;

    /**
     * 行程景点时间
     */

    private String commodTripTime;

    /**
     * 行程景点排序
     */

    private String commodTripSort;

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
