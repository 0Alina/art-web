package com.application.art.controller;

import com.application.art.dto.AboutDto;
import com.application.art.service.AboutService;
import com.application.art.service.AboutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AboutController {

    @Autowired
    private AboutServiceImpl aboutService;

    @PostMapping("/about/update")
    public String updateAbout(@ModelAttribute AboutDto aboutDto,
                              @RequestParam("profileImage") MultipartFile profileImage) {

        try {
            aboutService.updateAbout(aboutDto, profileImage);
        } catch (IOException e) {
            // Log the exception and handle it
            e.printStackTrace();
            return "error";
        }

        return "redirect:/about";
    }


}
