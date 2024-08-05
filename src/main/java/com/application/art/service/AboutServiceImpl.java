package com.application.art.service;

import com.application.art.dto.AboutDto;
import com.application.art.entity.About;
import com.application.art.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AboutDto getAboutInfo() {
        // Preluăm datele aferente ID-ului 1 din baza de date
        Optional<About> aboutOptional = aboutRepository.findById(1);

        // Dacă înregistrarea există, o returnăm ca AboutDto
        if (aboutOptional.isPresent()) {
            About about = aboutOptional.get();
            return new AboutDto(about.getId(), about.getName(), about.getSurname(), about.getEmail(),
                    about.getPhone(), about.getDescription());
        } else {
            // Dacă nu există o înregistrare cu ID-ul 1, returnăm un AboutDto gol sau putem trata altfel această situație
            return new AboutDto();
        }
    }

}
