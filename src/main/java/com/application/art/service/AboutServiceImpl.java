package com.application.art.service;

import com.application.art.dto.AboutDto;
import com.application.art.entity.About;
import com.application.art.repository.AboutRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutRepository aboutRepository;

    @Override
    public AboutDto getAboutInfo() {
        // Preluăm datele aferente ID-ului 1 din baza de date
        Optional<About> aboutOptional = aboutRepository.findById(1);

        // Dacă înregistrarea există, o returnăm ca AboutDto
        if (aboutOptional.isPresent()) {
            About about = aboutOptional.get();
            return new AboutDto(
                    about.getId(),
                    about.getFullName(),
                    about.getProfile(),
                    about.getEmail(),
                    about.getPhone(),
                    about.getAbout_me(),
                    about.getBase64Image()
            );
        } else {
            return new AboutDto();
        }
    }

    @Override
    public void updateAbout(AboutDto aboutDto, MultipartFile imageFile) {
        About about = new About();

        about.setId(1);
        about.setFullName(aboutDto.getFullName());
        about.setProfile(aboutDto.getProfile());
        about.setEmail(aboutDto.getEmail());
        about.setPhone(aboutDto.getPhone());
        about.setAbout_me(aboutDto.getAbout_me());

        try {
            if (!imageFile.isEmpty()) {
                about.setImage(imageFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image", e); // Add more specific error handling if needed
        }

        aboutRepository.save(about);

    }

}
