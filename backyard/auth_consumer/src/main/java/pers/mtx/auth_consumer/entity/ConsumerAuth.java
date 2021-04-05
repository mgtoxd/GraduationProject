package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.dozer.Mapping;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消费者认证表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class ConsumerAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id
     */

    private String conId;

    /**
     * 消费者邮箱
     */
    @Mapping("email")
    private String conEmail;

    /**
     * 消费者密码md5
     */
    @Mapping("password")
    private String conPassword;

    /**
     * 消费者手机号
     */
    @Mapping("phoneNum")
    private String conPhoneNum;

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
