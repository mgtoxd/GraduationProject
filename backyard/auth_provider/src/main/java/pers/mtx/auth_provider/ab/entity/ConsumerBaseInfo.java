package pers.mtx.auth_provider.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 消费者常用信息表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("consumer_base_info")
public class ConsumerBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id

     */
    @TableId(value = "con_id", type = IdType.ASSIGN_UUID)
    private String conId;

    /**
     * 消费者昵称
     */
    @TableField("con_name")
    private String conName;

    /**
     * 消费者头像

     */
    @TableField("con_ava")
    private String conAva;


}
