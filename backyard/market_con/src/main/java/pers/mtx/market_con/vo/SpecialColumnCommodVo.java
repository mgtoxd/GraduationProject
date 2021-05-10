package pers.mtx.market_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description: 专栏商品信息Vo
 * @DateTime: 2021/5/2 14:01
 **/
@Data
@Accessors(chain = true)
public class SpecialColumnCommodVo {
    /**
     * 专栏和商品关联id
     */

    private String specColumnCommodId;

    /**
     * 页面展示图片url
     */

    private String commodIndexImg;
    /**
     * 商品名称
     */

    private String commodName;

    /**
     * 商品简要描述
     */

    private String commodDescription;
}
