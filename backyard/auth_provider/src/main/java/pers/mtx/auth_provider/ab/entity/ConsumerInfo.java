package pers.mtx.auth_provider.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * 消费者详细信息表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("consumer_info")
public class ConsumerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id
     */
    @TableId(value = "con_id", type = IdType.ASSIGN_UUID)
    private String conId;

    /**
     * 消费者身份证号
     */
    @TableField("con_card_id")
    private String conCardId;

    /**
     * 消费者生日
     */
    @TableField("con_birthday")
    private LocalDate conBirthday;

    /**
     * 消费者性别
     */
    @TableField("con_sex")
    private String conSex;

    /**
     * 消费者民族
     */
    @TableField("con_nation")
    private String conNation;

    /**
     * 消费者国籍
     */
    @TableField("con_nationality")
    private String conNationality;

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
