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

@Controller
public class AboutController {

    @Autowired
    private AboutServiceImpl aboutService;

    @PostMapping("/about/update")
    public String updateAbout(@ModelAttribute("aboutDto") AboutDto aboutDto, BindingResult result, Model model){

        aboutService.updateAbout(aboutDto);

        return "redirect:/about";
    }

}
