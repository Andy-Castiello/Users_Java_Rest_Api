package com.demo.UsersRestApi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UsersRestApi.model.UserEntity;
import com.demo.UsersRestApi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ArrayList<UserEntity> getAllUser() {
		// TODO Auto-generated method stub
		return (ArrayList<UserEntity>) userRepository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userRepository.save(userEntity);
	}

	@Override
	public boolean deleteUserById(long id) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = getUserById(id);
		if (userEntity.isPresent()) {

			try {
				userRepository.delete(userEntity.get());
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		return false;
	}

}
