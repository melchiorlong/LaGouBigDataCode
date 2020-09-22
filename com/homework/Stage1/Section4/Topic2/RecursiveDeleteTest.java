package com.homework.Stage1.Section4.Topic2;

import java.io.File;
import java.io.FileFilter;

/**
 * @author tianlong
 * 实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 */
public class RecursiveDeleteTest {

    private static final String PATH_MAC = "/Users/tianlong/Desktop/LaGouBigDataStudy/src/com/homework/Stage1/Section4/Topic2/DeleteDemo";
    private static final String PATH_WINDOWS = "D://DeleteDemo";

    public static void main(String[] args) {
        File file = new File(PATH_MAC);
        delete(file);
        System.out.println("删除完成！");
    }

    public static void delete(File file) {
        File[] files = file.listFiles();

        // 判断指定目录下是否有文件
        if (files != null) {
            // 递归删除非目录文件
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                } else {
                    delete(f);
                }
            }
            // 递归删除目录文件
            for (File f : files) {
                if (f.isDirectory()) {
                    f.delete();
                } else {
                    delete(f);
                }
            }
        }
    }
}
