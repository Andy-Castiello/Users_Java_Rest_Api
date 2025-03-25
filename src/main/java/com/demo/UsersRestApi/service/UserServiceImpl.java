package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UsersRestApi.model.User;
import com.demo.UsersRestApi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<User> getAllUser() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public boolean deleteUserById(long id) {
		// TODO Auto-generated method stub
		try {
			Optional<User> user = getUserById(id);
			userRepository.delete(user.get());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
