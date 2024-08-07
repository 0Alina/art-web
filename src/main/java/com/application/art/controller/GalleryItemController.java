package com.application.art.controller;

import com.application.art.dto.GalleryItemDto;
import com.application.art.entity.GalleryItem;
import com.application.art.service.GalleryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/gallery")
@Controller
public class GalleryItemController {

    @Autowired
    private GalleryItemService galleryItemService;

    @GetMapping("/newGalleryItem")
    public String newGalleryItem(Model model) {
        //galleryItemDto din Model semnifica denumirea obiectului care il transmitem in view (pe pagina new-gallery-item)
        model.addAttribute("galleryItemDto", new GalleryItemDto());
        return "new-gallery-item";
    }

    @PostMapping("/saveGalleryItem")
    // GaleryItemDto e tipul de date, galleryItemDto este obiectul (variabila)
    public String saveGalleryItem(@ModelAttribute("galleryItemDto") GalleryItemDto galleryItemDto, @RequestParam("imageFile") MultipartFile imageFile) {
        galleryItemService.save(galleryItemDto, imageFile);
        return "redirect:/gallery";
    }

    @DeleteMapping("/deleteGalleryItem/{id}")
    public String deleteGalleryItem(@PathVariable Long id) {
        galleryItemService.delete(id);
        return "redirect:/gallery";
    }

}
