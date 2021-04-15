package pers.mtx.commodpro;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommodProApplication.class)
public class CodeGenerator {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    String sql = "create_date date null comment '创建时间',modify_date date null comment '更新时间',is_deleted int null comment '逻辑删除',";
    String path = "/src/main/java";
    String path2 = "";
    String path3 = "pers.mtx.commodpro.ab";
    String author = "mataoxun";
    String xmlPath = "/src/main/resources/mapper/xml/";
    boolean ifAllBuild = true;
    String tableName = "";
    @Test
    public void build(){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + path);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setIdType(IdType.ASSIGN_UUID);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(path2);
        pc.setParent(path3);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("vo", path3+".vo");
                map.put("result", path3+".result");
                this.setMap(map);
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        //xml路径
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + xmlPath + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //设置controller模板
        templateConfig.setController("templates/controller.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置(数据库表配置)
        StrategyConfig strategy = new StrategyConfig();
        //驼峰写法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //lombok模型
        strategy.setEntityLombokModel(true);
        //链式模型
        strategy.setChainModel(true);
        //生成注释
        strategy.setEntityTableFieldAnnotationEnable(true);
        //逻辑删除
        strategy.setLogicDeleteFieldName("is_deleted");
        //自动注入配置
        List<TableFill> tableFills = new ArrayList<>();
        TableFill updateTime = new TableFill("modify_date", FieldFill.INSERT_UPDATE);
        TableFill createTime = new TableFill("create_date", FieldFill.INSERT);
        TableFill isDeleted = new TableFill("is_deleted", FieldFill.INSERT);
        tableFills.add(updateTime);
        tableFills.add(createTime);
        tableFills.add(isDeleted);
        strategy.setTableFillList(tableFills);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        if (ifAllBuild){
            strategy.setExclude(tableName);
        }else {
            strategy.setInclude(tableName);
        }
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}