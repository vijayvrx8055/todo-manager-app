package com.vrx.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/uploadSingle")
    public String uploadSingleFile(@RequestParam("file") MultipartFile file) {
        logger.info("Name: {}",file.getName());
        logger.info("ContentType: {}",file.getContentType());
        logger.info("Original File Name: {}",file.getOriginalFilename());
        logger.info("File Size: {}",file.getSize());
        
        return "File test";
    }

    @PostMapping("/uploadMultiple")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        Arrays.stream(files).forEach(file -> {
            logger.info("FileName: {}",file.getOriginalFilename());
            logger.info("FileSize: {}",file.getSize());
            logger.info("--------------------------------");
        });
        return "Handle Multiple Files";
    }
}
