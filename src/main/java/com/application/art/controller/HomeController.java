package com.application.art.controller;

import com.application.art.dto.*;
import com.application.art.entity.GalleryItem;
import com.application.art.repository.GalleryItemRepository;
import com.application.art.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    //verificare git bla bla bra vla
    @Autowired
    private AboutServiceImpl aboutService;
    @Autowired
    private GalleryItemService galleryItemService;
    @Autowired
    private ContactServiceImpl contactService;
    @Autowired
    private NewsItemServiceImpl newsItemServiceImpl;
    @Autowired
    private GalleryItemRepository galleryItemRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<GalleryItemDto> recentItems = galleryItemService.getRecentGalleryItems(6);
        model.addAttribute("recentItems", recentItems);
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/services")
    public String services(Model model){
        model.addAttribute("page", "service");
        return "services";
    }

    @GetMapping("/gallery")
    public String gallery(Model model){
        List<GalleryItemDto> galleryItems = galleryItemService.getAllGalleryItems();
        model.addAttribute("galleryItems", galleryItems);
        model.addAttribute("page", "gallery");
        return "gallery";
    }

    @GetMapping("/news")
    public String news(Model model) {
        List<NewsItemDto> newsItems = newsItemServiceImpl.getAllNewsItems();
        model.addAttribute("newsItems", newsItems);
        model.addAttribute("page", "news");
        return "news";
    }


    @GetMapping("/news-single")
    public String newsSingle(Model model) {
        model.addAttribute("page", "news-single");
        return "news-single";
    }

    @GetMapping("/about")
    public String about(Model model) {

        AboutDto aboutDto = aboutService.getAboutInfo();

        model.addAttribute("aboutDto", aboutDto);
        model.addAttribute("page", "about");
        return "about";
    }


    @GetMapping("/contact")
    public String contact(Model model){

        ContactDto contactDto = new ContactDto();

        ContactDetailDto contactDetail = contactService.getContactInfo();

        model.addAttribute("contactDetail", contactDetail);
        model.addAttribute("contactDto", contactDto);
        model.addAttribute("page", "contact");

        return "contact";
    }

}
