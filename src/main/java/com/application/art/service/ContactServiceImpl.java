package com.application.art.service;

import com.application.art.dto.ContactDto;
import com.application.art.entity.Contact;
import com.application.art.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void newContact(ContactDto contactDto) {
            Contact contact = new Contact();

            contact.setFullName(contactDto.getFullName());
            contact.setEmail(contactDto.getEmail());
            contact.setSubject(contactDto.getSubject());
            contact.setMessage(contactDto.getMessage());

            contactRepository.save(contact);
    }

}
