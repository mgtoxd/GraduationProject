package pers.mtx.commodcon.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import pers.mtx.commodcon.entity.CommodPriceDate;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 9:31
 **/
@Data
@Accessors(chain = true)
public class setPriceVo {
    /**
     * 商品id
     */

    private String commodId;

    /**
     * 商品价格
     */

    private String commodPrice;

    private List<CommodPriceDate> commodPriceDateList;
}
