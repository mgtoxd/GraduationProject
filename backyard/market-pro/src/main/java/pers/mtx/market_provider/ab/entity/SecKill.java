package pers.mtx.market_provider.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 秒杀活动表 
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sec_kill")
public class SecKill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀活动时间
     */
    @TableField("sec_date_time")
    private LocalDateTime secDateTime;

    /**
     * 秒杀活动状态
     */
    @TableField("sec_status")
    private Integer secStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @TableId(value = "sec_kill_id", type = IdType.ASSIGN_UUID)
    private String secKillId;

    /**
     * 秒杀活动名称
     */
    @TableField("sec_name")
    private String secName;


}
