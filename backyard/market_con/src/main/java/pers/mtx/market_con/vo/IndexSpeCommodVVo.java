package pers.mtx.market_con.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IndexSpeCommodVVo {
        /**
         * 专栏图片
         */

        private String specColumnCommodImgUrl;
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
    }