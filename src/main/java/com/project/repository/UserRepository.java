package com.project.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.model.User;


public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByEmail(String email);
	@Query("{email : ?0, password : ?1}")
	public User findUserByEmailAndPassword(String email, String password);
	 
}
