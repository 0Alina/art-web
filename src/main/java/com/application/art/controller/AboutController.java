package com.application.art.controller;

import com.application.art.dto.AboutDto;
import com.application.art.service.AboutService;
import com.application.art.service.AboutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/about")
@Controller
public class AboutController {

    @Autowired
    private AboutServiceImpl aboutService;

    @GetMapping("/edit")
    public String editAbout(Model model) {

        model.addAttribute("aboutDto", new AboutDto());

        return "new-about";
    }

    @PostMapping("/update")
    public String updateAbout(@ModelAttribute AboutDto aboutDto,
                                @RequestParam("photo") MultipartFile photo) {

        aboutService.updateAbout(aboutDto, photo);
        return "redirect:/about";
    }


}
