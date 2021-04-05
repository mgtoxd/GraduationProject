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
 * 商铺管理者认证
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("businessman_auth")
public class BusinessmanAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺管理者id
     */
    @TableId(value = "bus_id", type = IdType.ASSIGN_UUID)
    private String busId;

    /**
     * 商铺管理者密码
     */
    @TableField("bus_password")
    private String busPassword;

    /**
     * 商铺管理者邮箱
     */
    @TableField("bus_email")
    private String busEmail;

    /**
     * 商铺管理者手机号
     */
    @TableField("bus_phone_num")
    private String busPhoneNum;

    /**
     * 管理商铺编号
     */
    @TableField("bus_store_id")
    private String busStoreId;

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
