package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.model.Product;



public interface Products  extends MongoRepository<Product, String> {

}
