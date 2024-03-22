package com.compass.dev.challengerbackend.controllers;

import com.compass.dev.challengerbackend.dto.CreateContact;
import com.compass.dev.challengerbackend.dto.CreateContactResponse;
import com.compass.dev.challengerbackend.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class ContactController {

    private final ContactService contactService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/create-contact")
    public CreateContactResponse createContact(@Valid CreateContact request) {
        return contactService.createContact(request);

    }
}
