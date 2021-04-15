package pers.mtx.commodcon.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品图像表
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class CommodImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 图片url
     */

    private String url;

    /**
     * 是否展示在外面界面
     */

    private Boolean isIndex;

    /**
     * 是否展示在content轮播
     */

    private Boolean isContent;

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
