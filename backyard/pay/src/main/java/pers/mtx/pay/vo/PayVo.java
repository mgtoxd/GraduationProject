package pers.mtx.pay.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/5/6 13:09
 **/
@Data
@Accessors(chain = true)
public class PayVo {

    private String out_trade_no;

    private Integer total_amount;

    private String subject;

    private String body;
}
