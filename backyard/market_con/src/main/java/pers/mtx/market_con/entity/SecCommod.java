package pers.mtx.market_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 秒杀商品表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class SecCommod implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀活动id
     */

    private String secId;

    /**
     * 商品id
     */

    private String comId;

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


    private String secCommodId;


}
