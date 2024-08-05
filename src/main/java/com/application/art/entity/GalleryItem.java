package com.application.art.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gallery_item")
public class GalleryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
}
