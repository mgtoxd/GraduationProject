package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消费者与等级绑定表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class ConsumerLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id
     */

    private String conId;

    /**
     * 等级名称
     */

    private String levelName;

    /**
     * 等级
     */

    private String level;

    /**
     * 等级所属的店铺id
     */

    private String storeId;

    /**
     * 创建时间
     */

    private LocalDateTime createDate;

    /**
     * 创建时间
     */

    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */

    private Integer isDeleted;


}
