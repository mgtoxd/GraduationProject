package pers.mtx.market_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description: 首页商品信息Vo(带商品名称)
 * @DateTime: 2021/5/2 14:01
 **/
@Data
@Accessors(chain = true)
public class IndexCommodPosVo {

    private String indexShowCommodId;
    /**
     * 商品名称
     */

    private String commodName;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 展示图片
     */

    private String imgUrl;

    /**
     * 介绍
     */

    private String introduce;

    /**
     * 位置
     */

    private String comPos;

    /**
     * 位置名称
     */

    private String posName;
}
