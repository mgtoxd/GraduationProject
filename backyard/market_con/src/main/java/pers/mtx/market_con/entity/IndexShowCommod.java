package pers.mtx.market_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 首页展示商品表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class IndexShowCommod implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 展示图片
     */

    private String imgUrl;

    /**
     * 介绍
     */

    private String introduce;

    /**
     * 位置
     */

    private String comPos;

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


    private String indexShowCommodId;


}
