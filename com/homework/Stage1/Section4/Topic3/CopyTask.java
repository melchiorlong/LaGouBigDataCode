package com.homework.Stage1.Section4.Topic3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTask implements Runnable {

    private static final String PATH_WINDOWS = "I:\\LaGou_BigData_Study\\src\\com\\homework\\Stage1\\Section4\\Topic3\\CopyDemo";
    private static final String PATH_MAC = "/Users/tianlong/Desktop/LaGouBigDataStudy/src/com/homework/Stage1/Section4/Topic2/DeleteDemo";

    @Override
    public void run() {
        File file = new File(PATH_WINDOWS);
        recursive(file);
        System.out.println("文件拷贝完成！");
    }

    public void recursive(File file) {
        File[] files = file.listFiles();

        // 判断指定目录下是否有文件
        if (files != null) {
            // 递归创建目录文件
            for (File f : files) {
                if (f.isDirectory()) {
                    String absolutePathNew = f.getAbsolutePath().replace("CopyDemo", "CopyDemoBak");
                    File fileNew = new File(absolutePathNew);
                    fileNew.mkdirs();
                } else {
                    recursive(f);
                }
            }
            // 递归创建非目录文件
            for (File f : files) {
                if (f.isFile()) {
                    copy(f);
                } else {
                    recursive(f);
                }
            }
        }
    }

    public void copy(File file) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1、创建FileInputStream类型的对象与路径中文件关联
            fis = new FileInputStream(file);
            // 2、创建FileOutputStream类型的对象与复制后的文件关联
            String absolutePath = file.getAbsolutePath();
            String absolutePathNew = absolutePath.replace("CopyDemo", "CopyDemoBak");
            fos = new FileOutputStream(absolutePathNew);
            // 3、从输入流中读取数据到输出流
            byte[] buffer = new byte[1024];
            int res = 0;
            if ((res = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流对象
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
