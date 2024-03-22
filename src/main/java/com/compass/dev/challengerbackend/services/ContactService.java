package com.compass.dev.challengerbackend.services;

import com.compass.dev.challengerbackend.dto.CreateContact;
import com.compass.dev.challengerbackend.dto.CreateContactResponse;

public sealed interface ContactService permits ContactServiceImpl{

    CreateContactResponse createContact(CreateContact createContact);
}
