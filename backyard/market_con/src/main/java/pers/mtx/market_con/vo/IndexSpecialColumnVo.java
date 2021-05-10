package pers.mtx.market_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/3 20:16
 **/
@Data
@Accessors(chain = true)
public class IndexSpecialColumnVo {


    /**
     * 专栏名称
     */

    private String specColumnTitle;

    /**
     * 专栏图片
     */

    private String specColumnImgUrl;



    private ArrayList<IndexSpeCommodVVo> items;
}
