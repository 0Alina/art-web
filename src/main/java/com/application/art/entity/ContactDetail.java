package com.application.art.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_detail")
public class ContactDetail {

    @Id
    @Column(name = "contact_detail_id")
    private int id = 1;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "pinterest")
    private String pinterest;
}
