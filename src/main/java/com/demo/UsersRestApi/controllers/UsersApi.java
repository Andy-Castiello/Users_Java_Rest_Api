package com.demo.UsersRestApi.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.UsersRestApi.model.UserEntity;
import com.demo.UsersRestApi.service.UserService;

@RestController
@RequestMapping("api/users")
public class UsersApi {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public ArrayList<UserEntity> getAllUsers() {

		return userService.getAllUser();
	}

	@GetMapping("/find/{id}")
	public Optional<UserEntity> getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/save")
	public UserEntity saveUser(@RequestBody UserEntity userEntity) {

		return userService.saveUser(userEntity);
	}

	@DeleteMapping("/delete/{id}")
	public String detelUser(@PathVariable("id") long id) {

		if (userService.deleteUserById(id))
			return "The user has been deleted successfully!!";
		else
			return "Something went wrong!. The user couln´t be deleted.";
	}
}
