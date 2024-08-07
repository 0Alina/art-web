package com.application.art.service;

import com.application.art.dto.AboutDto;
import org.springframework.web.multipart.MultipartFile;

public interface AboutService {

    void updateAbout(AboutDto about, MultipartFile profileImage);

}
