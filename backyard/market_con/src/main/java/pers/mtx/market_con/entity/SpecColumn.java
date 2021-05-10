package pers.mtx.market_con.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专栏管理表
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class SpecColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专栏id
     */

    private String specColumnId;

    /**
     * 专栏名称
     */

    private String specColumnTitle;

    /**
     * 专栏图片
     */

    private String specColumnImgUrl;

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
