package com.xubh.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot文件上传
 */
@RestController
public class FileUploadController {

    /**
     * 处理文件上传
     */
    @RequestMapping("/fileUploadController")
    public Map<String, Object> fileUpload(MultipartFile filename) throws Exception {
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("e:/" + filename.getOriginalFilename()));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }
}
