package com.application.art.controller;

import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("page", "home");
        return "index";
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

    @GetMapping("/portfolio")
    public String portfolio(Model model){
        model.addAttribute("page", "work");
        return "portfolio";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page", "contact");
        return "contact";
    }

}
