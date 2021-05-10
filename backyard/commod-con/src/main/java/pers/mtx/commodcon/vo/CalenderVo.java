package pers.mtx.commodcon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/4 16:34
 **/
@Data
@Accessors(chain = true)
public class CalenderVo {

    /**
     * 日
     */

    private String dateInMon;

    /**
     * 节日
     */

    private String festival;

    /**
     * 是否特殊
     */
    private boolean special;

    /**
     * 价格
     */
    private String price;
}
