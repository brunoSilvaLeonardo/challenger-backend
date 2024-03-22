package com.compass.dev.challengerbackend.services;

import com.compass.dev.challengerbackend.dto.CreateUser;
import com.compass.dev.challengerbackend.dto.ResponseCreateUser;

public interface UserService {

    ResponseCreateUser createUser(CreateUser createUser);
}
