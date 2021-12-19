package com.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.model.User;
import com.project.repository.UserRepository;

@Repository
public class UserDAO {
	@Autowired
	private UserRepository repository;

	public User registerUser(@RequestBody User user) {
		

		return repository.save(user);
	}

	public User findEmail(String email) {

		return repository.findByEmail(email);
	}

	public User findEmailandPassword(String email, String passowrd) {

		return repository.findUserByEmailAndPassword(email, passowrd);
	}

}
