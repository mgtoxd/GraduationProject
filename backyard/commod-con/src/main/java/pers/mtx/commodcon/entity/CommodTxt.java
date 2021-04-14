package pers.mtx.commodcon.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品详细描述
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommodTxt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 商品详细描述
     */

    private String commodTxt;

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
