package pers.mtx.commodcon.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import pers.mtx.commodcon.entity.CommodSku;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/30 11:19
 **/
@Data
@Accessors(chain = true)
public class SetSkuVo {
    private String id;
    private List<CommodSku> skuList;
}
