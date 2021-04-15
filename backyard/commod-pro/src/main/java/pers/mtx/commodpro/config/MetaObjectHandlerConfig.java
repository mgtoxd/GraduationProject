package pers.mtx.commodpro.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("start insert field....");
        this.setFieldValByName("createDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("modifyDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("isDeleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate", LocalDateTime.now(), metaObject);
    }
}
