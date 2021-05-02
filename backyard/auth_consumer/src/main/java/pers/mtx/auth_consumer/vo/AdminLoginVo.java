package pers.mtx.auth_consumer.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/26 10:42
 **/
@Data
@Accessors(chain = true)
public class AdminLoginVo {
    /**
     * 管理员登录名
     */

    private String adminName;

    /**
     * 管理员密码
     */

    private String adminPassword;

    /**
     * 工号
     */

    private String jobnumber;
}
