package pers.mtx.auth_consumer.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Author: 马韬循
 * @Description: 返回admin信息
 * @DateTime: 2021/4/26 11:03
 **/
@Data
@Accessors(chain = true)
public class AdminInfoVo {
    /**
     * 管理员id
     */

    private String adminId;
    /**
     * 管理员登录名
     */

    private String adminName;


    /**
     * 工号
     */

    private String jobnumber;
    /**
     * 创建时间
     */

    private LocalDateTime Date;
}
