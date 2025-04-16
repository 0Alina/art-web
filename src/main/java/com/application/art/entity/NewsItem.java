package com.application.art.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news_items")
public class NewsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private String date;
    @Column (name = "category")
    private String category;
    @Column (name = "description")
    private String description;
    @Column (name = "author")
    private String author;
    @Column (name = "time")
    private String time;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public String getBase64Image() {
        if (this.image != null) {
            return Base64.getEncoder().encodeToString(this.image);
        }
        return null;
    }

    public void setBase64Image(String base64Image) {
        if (base64Image != null) {
            this.image = Base64.getDecoder().decode(base64Image);
        } else {
            this.image = null;
        }
    }
}
