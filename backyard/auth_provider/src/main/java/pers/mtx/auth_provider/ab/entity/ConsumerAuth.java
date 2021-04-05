package pers.mtx.auth_provider.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("consumer_auth")
public class ConsumerAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id
     */
    @TableId(value = "con_id", type = IdType.ASSIGN_UUID)
    private String conId;

    /**
     * 消费者邮箱
     */
    @TableField("con_email")
    private String conEmail;

    /**
     * 消费者密码md5
     */
    @TableField("con_password")
    private String conPassword;

    /**
     * 消费者手机号
     */
    @TableField("con_phone_num")
    private String conPhoneNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 创建时间
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


}
