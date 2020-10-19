package com.study.Stage2.Section1.Task7.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Administrator
 */
public class XPathTest {

    // 利用XPath语法解析XML文件
    // 使用 selectSingleNode() 查询指定节点

    @Test
    public void test1 () throws DocumentException {
        // 1. 创建XML解析对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage2\\Section1\\Task7\\XPath\\book.xml");

        //3.调用 selectSingleNode() 方法,获取name节点对象
        Node node = document.selectSingleNode("/bookstore/book/name");
        System.out.println("节点名称是 " + node.getName());
        System.out.println("节点文本值是 " + node.getText());

        // 4. 获取第二本书的信息
        Node node2 = document.selectSingleNode("/bookstore/book[2]/name");
        System.out.println("节点名称是 " + node2.getName());
        System.out.println("节点文本值是 " + node2.getText());


    }


    /*
     * 2.使用selectSingleNode方法 获取属性值,或者属性值对应的节点
     * */

    @Test
    public void test2 () throws DocumentException {
        // 1. 创建XML解析对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage2\\Section1\\Task7\\XPath\\book.xml");

        // 2.获取第一个book节点的 id属性的值
        Node node1 = document.selectSingleNode("/bookstore/book/attribute::id");
        System.out.println("第一个属性值 " + node1.getText());

        // 3.获取最后一个book节点的 id属性的值
        Node node2 = document.selectSingleNode("/bookstore/book[last()]/attribute::id");
        System.out.println("最后一个属性值 " + node2.getText());

        // 4. 通过id值获取 book2 的属性值
        Node node3 = document.selectSingleNode("/bookstore/book[@id = 'book2']");
        Node name = node3.selectSingleNode("name");
        System.out.println("id为book2的书名是 " + name.getText());
    }

    /*
     * 3.使用 selectNodes()方法 获取对应名称的所有节点
     * */

    @Test
    public void test3 () throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("I:\\LaGou_BigData_Study\\src\\com\\study\\Stage2\\Section1\\Task7\\XPath\\book.xml");

        // 1. 获取所有节点名
        List<Node> list = document.selectNodes("//*");
        for (Node node : list) {
            System.out.println("所有节点名是 " + node.getName());
        }

        System.out.println("------------------------------------------");

        // 2. 获取所有书名
        List<Node> list1 = document.selectNodes("//name");
        for (Node node : list1) {
            System.out.println("所有书名是 " + node.getText());
        }

        System.out.println("------------------------------------------");

        //5.获取指定 id 值为 book1 的节点的所有内容
        List<Node> list2 = document.selectNodes("/bookstore/book[@id = 'book1']//*");
        for (Node node : list2) {
            System.out.println(node.getName() + "是" + node.getText());
        }

    }





}
