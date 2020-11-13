package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Administrator
 * 1. 导入fileupload和io坐标
 * 2. 配置文件上传解析器
 * 3. 编写文件上传代码
 */
@Controller
public class FileUploadController {

    // 单位件上传

    @RequestMapping("/fileupload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {
        // 获取表单提交参数 完成上传
        System.out.println(username);
        // 获取原始文件名
        String originalFilename = filePic.getOriginalFilename();
        filePic.transferTo(new File("I:/upload/" +originalFilename));
        return "success";
    }

    // 多位件上传


    @RequestMapping("/filesupload")
    public String filesUpload(String username, MultipartFile[] filePic) throws IOException {
        // 获取表单提交参数 完成上传
        System.out.println(username);
        // 获取原始文件名
        for (MultipartFile multipartFile : filePic) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("I:/upload/" + originalFilename));
        }
        return "success";
    }

}
