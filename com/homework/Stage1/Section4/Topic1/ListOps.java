package com.homework.Stage1.Section4.Topic1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @author tianlong
 */
public class ListOps {

    private static final String FILE_PATH = "/Users/tianlong/Desktop/LaGouBigDataStudy/src/com/homework/Stage1/Section4/Topic1/Data.txt";

    public static void add(List<Student> list, Student s) {
        list.add(s);
    }

    public static void delete(List<Student> list, String id) {

        Student delete_s = new Student();
        for (Student s : list) {
            if (s.getId() == Integer.parseInt(id)) {
                delete_s = s;
            }
        }
        list.remove(delete_s);
    }

    public static Student findId(List<Student> list, String find_id) {
        for (Student stu : list
        ) {
            if (stu.getId() == Integer.parseInt(find_id)) {
                return stu;
            }
        }
        return null;
    }

    public static List<Student> findName(List<Student> list, String find_name) {
        List<Student> resultList = new ArrayList<>();
        for (Student stu : list
        ) {
            if (stu.getName().equals(find_name)) {
                resultList.add(stu);
            }
        }
        return resultList;
    }

    public static List<Student> findAge(List<Student> list, String find_age) {
        List<Student> resultList = new ArrayList<>();
        for (Student stu : list
        ) {
            if (stu.getAge() == Integer.parseInt(find_age)) {
                resultList.add(stu);
            }
        }
        return resultList;
    }

    public static void save(List<Student> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH);
            String s = JSON.toJSONString(list);
            fileWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Student> load() {

        FileInputStream fis = null;
        InputStreamReader isr = null;
        StringBuffer sb = new StringBuffer();
        List<String> listTemp = new ArrayList<>();
        List<Student> list = new ArrayList<>();
        try {
            File f = new File(FILE_PATH);
//            FileOutputStream fop = new FileOutputStream(f);
            fis = new FileInputStream(FILE_PATH);
            isr = new InputStreamReader(fis, "UTF-8");
            while (isr.ready()) {
                sb.append((char) isr.read());
            }
            String jsonStr = sb.toString();
            JSONArray jsonArray = JSON.parseArray(jsonStr);
            for (Object obj :jsonArray ) {
                Student student = JSON.parseObject(String.valueOf(obj), Student.class);
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
