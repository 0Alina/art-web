package com.application.art.controller;

import com.application.art.dto.ContactDto;
import com.application.art.entity.Contact;
import com.application.art.service.ContactService;
import com.application.art.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("/save")
    public String newContact(@ModelAttribute ContactDto contactDto){

            contactService.newContact(contactDto);

        return "redirect:/contact";
    }
}
