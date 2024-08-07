package com.application.art.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private int id;

    private String fullName;

    private String email;

    private String subject;

    private String message;

}
