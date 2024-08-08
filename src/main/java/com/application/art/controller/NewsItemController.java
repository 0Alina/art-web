package com.application.art.controller;


import com.application.art.dto.NewsItemDto;
import com.application.art.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/news")
public class NewsItemController {

    @Autowired
    private NewsItemService newsItemService;

    @GetMapping("/newNewsItem")
    public String newsItem(Model model) {
        model.addAttribute("newsItem", new NewsItemDto());
        return "new-news-item";
    }

    @PostMapping("/saveNewsItem")
    public String saveNewsItem(@ModelAttribute("newsItem") NewsItemDto newsItemDto, @RequestParam("photo") MultipartFile photo) {
        newsItemService.save(newsItemDto, photo);
        return "redirect:/news";
    }

}

