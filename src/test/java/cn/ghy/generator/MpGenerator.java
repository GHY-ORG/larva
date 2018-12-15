package cn.ghy.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ziyang
 * @Email: meetziyang@gmail.com
 * @Date: 2018/8/29 14:06
 * @Description:
 */
class MpCodeGenerator {

    public static void main(String[] args) {
        String packageName = "cn.ghy";
        generateByTables(packageName, "role", "permission", "user_role", "role_permission");
    }

    public static void generateByTables(String packageName, String... tableNames) {

        final String projectPath = System.getProperty("user.dir");

        GlobalConfig globalConfig = new GlobalConfig().setOutputDir(projectPath + "/src/main/java")
                .setAuthor("Ziyang").setFileOverride(false).setOpen(false).setServiceName("%sService");

        DataSourceConfig dataSourceConfig = new DataSourceConfig().setUrl(
                "jdbc:mysql://localhost:3306/larva?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false")
                .setUsername("root").setPassword("APTX4869").setDriverName("com.mysql.cj.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig().setCapitalMode(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)
                .setControllerMappingHyphenStyle(true);

        final PackageConfig packageConfig = new PackageConfig().setParent(packageName);

        TemplateConfig templateConfig = new TemplateConfig().setXml(null);

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName()
                        + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);

        AutoGenerator autoGenerator = new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig).setStrategy(strategyConfig).setPackageInfo(packageConfig)
                .setCfg(injectionConfig).setTemplate(templateConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();
    }
}