package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员认证
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class AdminAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */

    private String adminId;

    /**
     * 管理员登录名
     */

    private String adminName;

    /**
     * 管理员密码
     */

    private String adminPassword;

    /**
     * 创建时间
     */

    private LocalDateTime createDate;

    /**
     * 逻辑删除
     */

    private Integer isDeleted;

    /**
     * 更新时间
     */
    private LocalDateTime modifyDate;


}
