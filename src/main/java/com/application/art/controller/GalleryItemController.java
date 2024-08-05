package com.application.art.controller;

import com.application.art.entity.GalleryItem;
import com.application.art.service.GalleryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/gallery")
@Controller
public class GalleryItemController {

    @Autowired
    private GalleryItemService galleryItemService;

    @GetMapping("/newGalleryItem")
    public String newGalleryItem(Model model) {
        model.addAttribute("galleryItem", new GalleryItem());
        return "new-gallery-item";
    }

    @PostMapping("/saveGalleryItem")
    public String saveGalleryItem(@ModelAttribute("galleryItem") GalleryItem galleryItem) {
        galleryItemService.save(galleryItem);
        return "redirect:/gallery";
    }
}
