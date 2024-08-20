package com.application.art.controller;

import com.application.art.dto.RegisterDto;
import com.application.art.entity.AppUser;
import com.application.art.repository.AppUserRepository;
import com.application.art.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class AccountController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //register--------------------------------------------
    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerSuccess(Model model,
                                  @Valid @ModelAttribute("registerDto") RegisterDto registerDto,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes) {

        AppUser appUser = appUserRepository.findByEmail(registerDto.getEmail());

        if (appUser != null && appUser.getEmail() != null && !appUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            // Salvează erorile și datele introduse în sesiune
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDto", result);
            redirectAttributes.addFlashAttribute("registerDto", registerDto);
            return "register";
        }

        try {
            // Creează un nou cont
            AppUser newUser = new AppUser();
            newUser.setName(registerDto.getFirstName() + " " + registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setRole("ROLE_USER");
            newUser.setCreatedAt(new Date());
            newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

            appUserRepository.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);

        } catch (Exception ex) {
            result.addError(new FieldError("registerDto", "firstName", ex.getMessage()));
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDto", result);
            redirectAttributes.addFlashAttribute("registerDto", registerDto);
            return "redirect:/register";
        }

        return "redirect:/index";
    }


    //login-----------------------------------------------
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

}
