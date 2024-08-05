package com.application.art.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "about")
public class About {

    @Id
    @Column(name = "id")
    private int id = 1;

    @Column(name  = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "profileImage", columnDefinition = "LONGBLOB")
    private byte[] profileImage;

    @Transient
    private String profileImageBase64;

    public String getBase64Image() {
        if (this.profileImage != null) {
            return Base64.getEncoder().encodeToString(this.profileImage);
        }
        return null;
    }
}
