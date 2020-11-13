package com.lagou.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public class BeanFactory {

    private static HashMap<String, Object> iocMap = new HashMap<>();


    // 程序启动时 初始化实例对象
    static {

        // 读取配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        // 解析xml 使用dom4j
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(resourceAsStream);

            // 编写XPath表达式
            String xpath = "//bean";

            // 获取到bean标签
            List<Element> list = document.selectNodes(xpath);


            // 遍历list集合 并使用反射 创建对象实例 存放到map中

            for (Element element : list) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // 使用反射生成实例对象
                Object o = Class.forName(className).newInstance();
                // 存入map中
                iocMap.put(id, o);
            }

        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean (String beanId){

        return iocMap.get(beanId);
    }
}
