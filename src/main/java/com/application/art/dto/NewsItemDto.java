package com.application.art.dto;

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
}