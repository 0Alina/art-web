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

    @Column(name  = "fullName")
    private String fullName;

    @Column(name = "profile")
    private String profile;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "about_me", columnDefinition = "LONGBLOB")
    private String about_me;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public String getBase64Image() {
        if (this.image != null) {
            return Base64.getEncoder().encodeToString(this.image);
        }
        return null;
    }

    public void setBase64Image(String base64Image) {
        if (base64Image != null) {
            this.image = Base64.getDecoder().decode(base64Image);
        } else {
            this.image = null;
        }
    }
}
