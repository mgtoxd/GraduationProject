package pers.mtx.market_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/4 9:38
 **/
@Data
@Accessors(chain = true)
public class SecKillCommodVo {

    /**
     * 页面展示图片url
     */

    private String commodIndexImg;

    /**
     * 商品id
     */

    private String commodId;

    /**
     * 商品名称
     */

    private String commodName;

    /**
     * 商品简要描述
     */

    private String commodDescription;

    /**
     * 秒杀价格
     */

    private Integer secPrice;
}
