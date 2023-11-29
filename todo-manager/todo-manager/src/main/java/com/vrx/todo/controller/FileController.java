package com.vrx.todo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/uploadSingle")
    public String uploadSingleFile(@RequestParam("file") MultipartFile file) {
        logger.info("Name: {}", file.getName());
        logger.info("ContentType: {}", file.getContentType());
        logger.info("Original File Name: {}", file.getOriginalFilename());
        logger.info("File Size: {}", file.getSize());

        return "File test";
    }

    @PostMapping("/uploadMultiple")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        Arrays.stream(files).forEach(file -> {
            logger.info("FileName: {}", file.getOriginalFilename());
            logger.info("FileSize: {}", file.getSize());
            logger.info("--------------------------------");
        });
        return "Handle Multiple Files";
    }

    //serving image files in response
    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response) {
        try {
            InputStream fileInputStream = new FileInputStream("images/profile.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
