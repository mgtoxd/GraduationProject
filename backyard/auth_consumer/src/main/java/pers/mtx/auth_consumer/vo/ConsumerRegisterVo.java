package pers.mtx.auth_consumer.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import com.github.dozermapper.core.Mapping;

import java.time.LocalDate;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/5 22:54
 **/
@Data
@Accessors(chain = true)
public class ConsumerRegisterVo {

    /**
     * 消费者头像

     */
    private String conAva;
    /**
     * 消费者昵称
     */
    private String conName;

    private String conEmail;

    private String conPassword;

    private String conPhoneNum;

    private LocalDate conBirthday;

    private String conSex;

    private String conNation;

    private String conNationality;

    private String conCardId;
}
