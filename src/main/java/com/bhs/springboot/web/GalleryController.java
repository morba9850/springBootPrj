package com.bhs.springboot.web;

import com.bhs.springboot.dto.GalleryDto;
import com.bhs.springboot.service.GalleryService;
import com.bhs.springboot.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

    @Controller
    @AllArgsConstructor
    public class GalleryController {

        private S3Service s3Service;
        private GalleryService galleryService;

        @GetMapping("/gallery")
        public String dispWrite() {

            return "/gallery";
        }

        @PostMapping("/gallery")
        public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
            String imgPath = s3Service.upload(file);
            galleryDto.setFilePath(imgPath);



            galleryService.savePost(galleryDto);

            return "redirect:/gallery";
        }
    }


