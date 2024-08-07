package com.application.art.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailDto {

    private int id = 1;

    private String description;

    private String address;

    private String phone;

    private String email;

    private String facebook;

    private String instagram;

    private String twitter;

    private String pinterest;

}


