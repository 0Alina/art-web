package com.application.art.service;

import com.application.art.dto.ContactDetailDto;
import com.application.art.dto.ContactDto;

public interface ContactService {

    void newContact(ContactDto contactDto);

    ContactDetailDto getContactInfo();

    void editContactInfo(ContactDetailDto contactDetailDto);

}
