package com.application.art.service;

import com.application.art.dto.AboutDto;
import com.application.art.entity.About;
import com.application.art.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl {

    @Autowired
    private AboutRepository aboutRepository;

    public void updateAbout(AboutDto aboutDto) {

        About about = new About();

        about.setId(1);
        about.setName(aboutDto.getName());
        about.setSurname(aboutDto.getSurname());
        about.setEmail(aboutDto.getEmail());
        about.setPhone(aboutDto.getPhone());
        about.setDescription(aboutDto.getDescription());

        aboutRepository.save(about);
    }

}
