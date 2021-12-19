package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dao.UserDAO;
import com.project.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO dao;

	public User registerUser(@RequestBody User user) {

		return dao.registerUser(user);
	}

	public User findEmail(String email) {

		return dao.findEmail(email);
	}

	public User findEmailandPassword(String email, String passowrd) {

		return dao.findEmailandPassword(email, passowrd);
	}

}
