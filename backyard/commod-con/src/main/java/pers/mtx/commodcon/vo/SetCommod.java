package pers.mtx.commodcon.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import pers.mtx.commodcon.entity.CommodTripInfo;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/14 20:51
 **/
@Data
@Accessors(chain = true)
public class SetCommod {

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
     * 库存
     */

    private Long stock;

    /**
     * 最低库存
     */

    private String lowStock;

    /**
     * 页面展示图片url
     */

    private String commodIndexImg;

    /**
     * 轮播图图片url列表
     */
    private List<String> caroulurls;

    /**
     * 分类idList
     */

    private List<String> classifyIds;

    /**
     * 商品价格
     */

    private String commodPrice;

    /**
     * 行程列表
     */
    private List<CommodTripInfo> trips;

    /**
     * 商品详细描述
     */

    private String commodTxt;

}
