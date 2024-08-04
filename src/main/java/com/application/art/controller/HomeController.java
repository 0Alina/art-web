package com.application.art.controller;

import com.application.art.dto.AboutDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/index1")
    public String index1(Model model) {
        model.addAttribute("page", "home");
        return "index1";
    }

    @GetMapping("/news")
    public String news(Model model){
        model.addAttribute("page", "news");
        return "news";
    }

    @GetMapping("/news-single")
    public String newsSingle(Model model) {
        model.addAttribute("page", "news-single");
        return "news-single";
    }

    @GetMapping("/services")
    public String services(Model model){
        model.addAttribute("page", "service");
        return "services";
    }

    @GetMapping("/gallery")
    public String gallery(Model model){
        model.addAttribute("page", "gallery");
        return "gallery";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("page", "about");
        model.addAttribute("aboutDto", new AboutDto());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page", "contact");
        return "contact";
    }

}
