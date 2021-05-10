package pers.mtx.comments_con.entity;





import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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

public class ConsumerBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id

     */

    private String conId;

    /**
     * 消费者昵称
     */
    private String conName;

    /**
     * 消费者头像

     */
    private String conAva;


}
