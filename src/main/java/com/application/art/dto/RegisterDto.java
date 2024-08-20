package com.application.art.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Email is required")
    private String email;

    @Size (min = 8, message = "Minimum Password length is 6 characters")
    private String password;

}
