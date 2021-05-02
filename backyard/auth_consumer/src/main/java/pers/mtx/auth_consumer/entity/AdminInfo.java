package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员信息
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */

    private String adminId;

    /**
     * 工号
     */

    private String jobnumber;

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
