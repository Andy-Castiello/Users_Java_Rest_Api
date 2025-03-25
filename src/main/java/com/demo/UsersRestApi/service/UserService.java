package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import com.demo.UsersRestApi.model.User;

public interface UserService {

	ArrayList<User> getAllUser();

	Optional<User> getUserById(long id);

	User saveUser(User user);

	boolean deleteUserById(long id);
}
