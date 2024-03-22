package com.compass.dev.challengerbackend.repository;

import com.compass.dev.challengerbackend.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
