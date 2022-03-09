package com.myq.springbootfileupdoad.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 */
@RestController
public class FileUploadController {
    /**
     * 文件上传
     */
    @PostMapping("/fileUploadController")
    public String fileUpload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("F:/"+file.getOriginalFilename()));
        return "OK";
    }
}
