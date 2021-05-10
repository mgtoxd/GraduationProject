package pers.mtx.market_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 秒杀活动表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class SecKill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀活动时间
     */

    private LocalDateTime secDateTime;

    /**
     * 秒杀活动状态
     */

    private Integer secStatus;

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


    private String secKillId;

    /**
     * 秒杀活动名称
     */

    private String secName;


}
