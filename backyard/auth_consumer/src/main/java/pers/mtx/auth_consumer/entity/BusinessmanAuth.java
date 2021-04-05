package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商铺管理者认证
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BusinessmanAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺管理者id
     */

    private String busId;

    /**
     * 商铺管理者密码
     */

    private String busPassword;

    /**
     * 商铺管理者邮箱
     */

    private String busEmail;

    /**
     * 商铺管理者手机号
     */

    private String busPhoneNum;

    /**
     * 管理商铺编号
     */

    private String busStoreId;

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
