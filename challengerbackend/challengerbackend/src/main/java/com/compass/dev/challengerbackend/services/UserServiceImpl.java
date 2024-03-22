package com.compass.dev.challengerbackend.services;

import com.compass.dev.challengerbackend.domain.UserEntity;
import com.compass.dev.challengerbackend.dto.CreateUser;
import com.compass.dev.challengerbackend.dto.ResponseCreateUser;
import com.compass.dev.challengerbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseCreateUser createUser(CreateUser createUser) {
        var userEntity = UserEntity.builder()
                .userId(createUser.getUserId())
                .fullName(createUser.getFullName())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .birthDate(createUser.getBirthDate().toString())
                .build();


        repository.save(userEntity);
        return new ResponseCreateUser("User created");

    }
}
