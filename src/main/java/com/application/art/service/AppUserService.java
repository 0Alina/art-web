package com.application.art.service;

import com.application.art.dto.RegisterDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface AppUserService {

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException ;

}
