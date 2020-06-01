package com.bhs.springboot.web;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.GalleryDto;
import com.bhs.springboot.service.GalleryService;
import com.bhs.springboot.service.PostsService;
import com.bhs.springboot.dto.postDto.PostsResponseDto;
import com.bhs.springboot.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private S3Service s3Service;
    private GalleryService galleryService;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        /*SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userNames", user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/myinfo")
    public String myInfo(Model model, @LoginUser SessionUser user) {

        /*SessionUser user = (SessionUser) httpSession.getAttribute("user");*/
        model.addAttribute("userNames", user.getName());


        return "myinfo";
    }

    @GetMapping("/diary")
    public String diary(Model model, @LoginUser SessionUser user) {

        /*SessionUser user = (SessionUser) httpSession.getAttribute("user");*/
        model.addAttribute("userNames", user.getName());
        model.addAttribute("posts", postsService.findAllDesc());

        return "diary";
    }





}





