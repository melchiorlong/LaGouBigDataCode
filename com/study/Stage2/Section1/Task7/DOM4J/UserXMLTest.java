package com.study.Stage2.Section1.Task7.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Administrator
 * 解析XML
 */
public class UserXMLTest {

    // 获取XML文件中的所有元素

    @Test
    public void test1 () throws DocumentException {
        // 1.获取XML解析对象
        SAXReader reader = new SAXReader();

        // 2.解析XML 获取文档对象 document
        Document document = reader.read("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage2\\Section1\\Task7\\DOM4J\\user.xml");

        // 3. 获取根元素
        Element rootElement = document.getRootElement();
        System.out.println("根元素名称是： " + rootElement.getName());

        // 4. 获取根元素下的标签名称
        List<Element> elements = rootElement.elements();

        for (Element element : elements) {
            System.out.println("子节点名是 " + element.getName() + element.attributeValue("id"));
            List<Element> elements1 = element.elements();
            for (Element element1 : elements1) {
                System.out.println("子节点内容是 " + element1.getName() + " : " + element1.getText());
            }
        }
    }
}
