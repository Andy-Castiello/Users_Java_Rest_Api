package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import com.demo.UsersRestApi.model.UserEntity;

public interface UserService {

	ArrayList<UserEntity> getAllUser();

	Optional<UserEntity> getUserById(long id);

	UserEntity saveUser(UserEntity userEntity);

	boolean deleteUserById(long id);
}
