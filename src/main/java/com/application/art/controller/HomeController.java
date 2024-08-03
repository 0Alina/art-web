package com.application.art.controller;

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

    @GetMapping("/blog")
    public String blogSingle(Model model){
        model.addAttribute("page", "blog");
        return "blog";
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

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page", "contact");
        return "contact";
    }

}
