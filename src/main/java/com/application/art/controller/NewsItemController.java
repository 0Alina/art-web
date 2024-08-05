package com.application.art.controller;


import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;
import com.application.art.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsItemController {

    @Autowired
    private NewsItemService newsItemService;

    @GetMapping("/newNewsItem")
    public String newsItemController(Model model) {
        model.addAttribute("newsItem", new NewsItemDto());
        return "new-news-item";
    }

    @PostMapping("/saveNewsItem")
    public String saveNewsItem(@ModelAttribute("newsItem") NewsItemDto newsItemDto) {
        newsItemService.save(newsItemDto);
        return "redirect:/news";
    }
}

