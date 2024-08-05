package com.application.art.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalleryItemDto {
    private Long id;
    @Size(min = 2, max = 50)
    private String title;
    private String date;
}
