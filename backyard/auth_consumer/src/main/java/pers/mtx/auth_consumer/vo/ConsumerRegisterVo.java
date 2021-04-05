package pers.mtx.auth_consumer.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.dozer.Mapping;

import java.time.LocalDate;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/5 22:54
 **/
@Data
@Accessors(chain = true)
public class ConsumerRegisterVo {

    private String email;

    private String password;

    private String phoneNum;

    private LocalDate birthday;

    private String sex;

    private String nation;

    private String nationality;

    private String cardId;
}
