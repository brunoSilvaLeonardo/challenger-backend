package com.compass.dev.challengerbackend.services;

import com.compass.dev.challengerbackend.dto.CreateContact;
import com.compass.dev.challengerbackend.dto.CreateContactResponse;
import org.springframework.stereotype.Service;

@Service
public final class ContactServiceImpl implements ContactService {
    @Override
    public CreateContactResponse createContact(CreateContact createContact) {


        return new CreateContactResponse("Thank [contact.name], for getting in touch and sharing " +
                                         "your interests. We look forward to hearing from you soon.");
    }
}
