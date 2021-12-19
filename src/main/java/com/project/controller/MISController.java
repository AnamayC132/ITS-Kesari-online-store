package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;

import com.project.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class MISController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	@CrossOrigin(origins="*")
	public User registerUser(@RequestBody User user) throws Exception {

		String tempEmailID = user.getEmail();
		User userObj = service.findEmail(tempEmailID);
		if (userObj != null) {
			throw new Exception("User already exist");
		}
		userObj = service.registerUser(user);
		return userObj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins="*")
	public User login(@RequestBody User user) throws Exception {
		String tempEmailID = user.getEmail();
		String tempPassword = user.getPassword();
		User userObj = null;
		if (tempEmailID != null && tempPassword != null) {
			userObj = service.findEmailandPassword(tempEmailID, tempPassword);
		}
		if (userObj == null) {
			throw new Exception("User does not exist");
		} else {
			System.out.println("Login Success");
		}
		return userObj;
	}

}
