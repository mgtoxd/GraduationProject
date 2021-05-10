//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import pers.mtx.order_pro.OrderProApplication;
//import pers.mtx.order_pro.ab.controller.OrderInfoController;
//import pers.mtx.order_pro.ab.controller.OrderStateController;
//import pers.mtx.order_pro.ab.entity.OrderState;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = OrderProApplication.class)
//public class test {
//    @Autowired
//    OrderStateController orderStateController;
//
//    @Test
//    public void go(){
//        orderStateController.updateById(new OrderState().setStateName("未支付").setStateId(1));
//        orderStateController.updateById(new OrderState().setStateName("已支付未使用").setStateId(2));
//        orderStateController.updateById(new OrderState().setStateName("已使用未评论").setStateId(3));
//        orderStateController.updateById(new OrderState().setStateName("被管理员取消").setStateId(4));
//    }
//}