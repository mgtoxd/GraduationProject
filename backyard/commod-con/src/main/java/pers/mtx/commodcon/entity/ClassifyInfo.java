package pers.mtx.commodcon.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品分类信息表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class ClassifyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */

    private String classifyId;

    /**
     * 分类名称
     */

    private String classifyName;

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
