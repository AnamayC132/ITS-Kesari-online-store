package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.model.Orders;



public interface OrdersRepository extends MongoRepository<Orders, String>{

}
