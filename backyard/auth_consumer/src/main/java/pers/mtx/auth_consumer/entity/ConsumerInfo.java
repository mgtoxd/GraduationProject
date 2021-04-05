package pers.mtx.auth_consumer.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.dozer.Mapping;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

public class ConsumerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消费者id
     */

    private String conId;

    /**
     * 消费者身份证号
     */
    @Mapping("cardId")
    private String conCardId;

    /**
     * 消费者生日
     */
    @Mapping("birthday")
    private LocalDate conBirthday;

    /**
     * 消费者性别
     */
    @Mapping("sex")
    private String conSex;

    /**
     * 消费者民族
     */
    @Mapping("nation")
    private String conNation;

    /**
     * 消费者国籍
     */
    @Mapping("nationality")
    private String conNationality;

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
