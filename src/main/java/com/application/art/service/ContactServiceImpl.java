package com.application.art.service;

import com.application.art.dto.ContactDetailDto;
import com.application.art.dto.ContactDto;
import com.application.art.entity.Contact;
import com.application.art.entity.ContactDetail;
import com.application.art.repository.ContactDetailRepository;
import com.application.art.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactDetailRepository contactDetailRepository;

    @Override
    public void newContact(ContactDto contactDto) {
            Contact contact = new Contact();

            contact.setFullName(contactDto.getFullName());
            contact.setEmail(contactDto.getEmail());
            contact.setSubject(contactDto.getSubject());
            contact.setMessage(contactDto.getMessage());

            contactRepository.save(contact);
    }


    //Contact Details ------------------------------------------------------------
    @Override
    public ContactDetailDto getContactInfo(){

        Optional<ContactDetail> optionalContactDetail = contactDetailRepository.findById(1);

        if(optionalContactDetail.isPresent()){
            ContactDetail contactDetail = optionalContactDetail.get();
            return new ContactDetailDto(
                    contactDetail.getId(),
                    contactDetail.getEmail(),
                    contactDetail.getAddress(),
                    contactDetail.getPhone(),
                    contactDetail.getDescription(),
                    contactDetail.getFacebook(),
                    contactDetail.getInstagram(),
                    contactDetail.getTwitter(),
                    contactDetail.getPinterest()
            );
        } else
            return new ContactDetailDto();
    }

    @Override
    public void editContactInfo(ContactDetailDto contactDetailDto){
        ContactDetail contactDetail = new ContactDetail();

        contactDetail.setAddress(contactDetailDto.getAddress());
        contactDetail.setEmail(contactDetailDto.getEmail());
        contactDetail.setPhone(contactDetailDto.getPhone());
        contactDetail.setDescription(contactDetailDto.getDescription());
        contactDetail.setFacebook(contactDetailDto.getFacebook());
        contactDetail.setInstagram(contactDetailDto.getInstagram());
        contactDetail.setTwitter(contactDetailDto.getTwitter());
        contactDetail.setPinterest(contactDetailDto.getPinterest());

        contactDetailRepository.save(contactDetail);

    }

}
