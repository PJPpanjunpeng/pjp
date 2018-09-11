package cn.itcast.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

public class FreemarkerTest {

    @Test
    public void test() throws Exception{
        //1、创建配置对象（指定版本、加载模版路径）
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置模版的编码
        configuration.setDefaultEncoding("utf-8");
        //设置模版路径
        configuration.setClassForTemplateLoading(FreemarkerTest.class, "/ftl");

        //2、获取模板
        Template template = configuration.getTemplate("test.ftl");

        //3、获取数据
        Map<String, Object> dataModel = new HashMap<String, Object>();
        dataModel.put("name", "JBL");
        dataModel.put("message", "传智播客");

        List<Map<String, Object>> goodsList = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "苹果");
        map1.put("price", 5.6);
        goodsList.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "香蕉");
        map2.put("price", 2.6);
        goodsList.add(map2);

        dataModel.put("goodsList", goodsList);

        dataModel.put("today", new Date());

        dataModel.put("number", 1234567890L);

        //输出对象
        FileWriter fileWriter = new FileWriter("D:\\itcast\\test\\test.html");

        //4、输出
        template.process(dataModel, fileWriter);

        fileWriter.close();
    }
}
