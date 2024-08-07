package com.application.art.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {

    private int id = 1;

    private String fullName;

    private String profile;

    private String email;

    private String phone;

    private String about_me;

    private String base64Image;

}
