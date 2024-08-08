package com.application.art.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewsItemDto {
    private Long id;
    private String title;
    private String content;
    private String date;
    private String base64Image;
    private String category;
    private String description;
    private String author;
    private String time;
}
