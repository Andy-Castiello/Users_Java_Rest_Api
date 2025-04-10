package com.demo.UsersRestApi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.UsersRestApi.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findUserByUsername(String username);

	Boolean existsByUsername(String username);
}
