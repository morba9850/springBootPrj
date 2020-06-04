package com.bhs.springboot.web;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.GalleryDto;
import com.bhs.springboot.service.GalleryService;
import com.bhs.springboot.service.S3Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
public class GalleryController {

    private S3Service s3Service;
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public String dispWrite(Model model) {
        log.info("갤러리 서비스 다녀오겟습니다");
        List<GalleryDto> galleryDtoList = galleryService.getList();
        log.info("갤러리 서비스 다녀왔습니다 뿌리겟습니다");
        model.addAttribute("galleryList", galleryDtoList);
        log.info(galleryDtoList);

        return "/gallery";
    }

    @PostMapping("/gallery")
    public String execWrite(GalleryDto galleryDto, MultipartFile file, @LoginUser SessionUser user) throws IOException {
        String imgPath = s3Service.upload(file);
        String name = user.getEmail();
        galleryDto.setName(name);
        galleryDto.setFilePath(imgPath);

        galleryService.savePost(galleryDto);

        return "redirect:/gallery";
    }

    @GetMapping
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {


        return "/gallery";
    }



}