package com.application.art.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GalleryItemDto {
    private Long id;
    @Size(min = 2, max = 50)
    private String title;
    private String date;
    private String base64Image;
}
