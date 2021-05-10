package pers.mtx.commodcon.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日历信息表
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CalendarInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年月
     */

    private String yearMon;

    /**
     * 日
     */

    private String dateInMon;

    /**
     * 节日
     */

    private String festival;

    /**
     * 创建时间
     */

    private LocalDateTime createDate;

    /**
     * 更新时间
     */

    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */

    private Integer isDeleted;


}
