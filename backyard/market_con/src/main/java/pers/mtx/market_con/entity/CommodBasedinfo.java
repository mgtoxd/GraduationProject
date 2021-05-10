package pers.mtx.market_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品基础信息
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommodBasedinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 商品名称
     */

    private String commodName;

    /**
     * 商品简要描述
     */

    private String commodDescription;

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

    /**
     * 页面展示图片url
     */

    private String commodIndexImg;


}
