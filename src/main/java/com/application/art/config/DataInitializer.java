package com.application.art.config;

import com.application.art.entity.About;
import com.application.art.entity.GalleryItem;
import com.application.art.repository.AboutRepository;
import com.application.art.repository.GalleryItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class DataInitializer {

    private final AboutRepository aboutRepository;

    private final GalleryItemRepository galleryItemRepository;

    private byte[] loadImage(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DataInitializer(AboutRepository aboutRepository, GalleryItemRepository galleryItemRepository) {
        this.aboutRepository = aboutRepository;
        this.galleryItemRepository = galleryItemRepository;
    }

    @PostConstruct
    public  void init(){
        addAbout();
        addGallery();
    }

    private void addAbout(){

        About about = new About(1, "Frimu Victor", "Pictor", "victorfrimu.art@gmail.com", "078007888",
                "Sunt un pictor pasionat de culori și forme, captiv de peisaje naturale și portrete pline de emoție.", loadImage("src/main/resources/static/img/victor.jpg"));

        aboutRepository.save(about);
    }

    private void addGallery(){

        GalleryItem galleryItem1 = new GalleryItem(1L, "Tablou 1", "20 noiembrie 2022",
                loadImage("src/main/resources/static/img/tablouri/img.png"));

        GalleryItem galleryItem2 = new GalleryItem(2L, "Tablou 2", "20 noiembrie 2022",
                loadImage("src/main/resources/static/img/tablouri/img_1.png"));

        GalleryItem galleryItem3 = new GalleryItem(3L, "Tablou 3", "20 noiembrie 2022",
                loadImage("src/main/resources/static/img/tablouri/img_2.png"));

        GalleryItem galleryItem4 = new GalleryItem(4L, "Tablou 4", "20 noiembrie 2022",
                loadImage("src/main/resources/static/img/tablouri/img_3.png"));

        GalleryItem galleryItem5 = new GalleryItem(5L, "Tablou 5", "20 noiembrie 2022",
                loadImage("src/main/resources/static/img/tablouri/img_4.png"));

        List<GalleryItem> galleryItems = List.of(galleryItem1, galleryItem2, galleryItem3, galleryItem4, galleryItem5);

        galleryItemRepository.saveAll(galleryItems);

    }

}
