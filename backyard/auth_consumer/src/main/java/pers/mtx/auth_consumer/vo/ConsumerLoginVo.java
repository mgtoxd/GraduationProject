package pers.mtx.auth_consumer.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import com.github.dozermapper.core.Mapping;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/7 21:43
 **/
@Data
@Accessors(chain = true)
public class ConsumerLoginVo {
    private String type;
    private String user;
    private String password;
}
