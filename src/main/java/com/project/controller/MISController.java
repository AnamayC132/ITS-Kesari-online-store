package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Orders;
import com.project.model.Product;
import com.project.model.User;
import com.project.repository.OrdersRepository;
import com.project.repository.Products;
import com.project.repository.UserRepository;
import com.project.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class MISController {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repository;
	@Autowired
	private Products prod_repository;
	
	@Autowired
	private OrdersRepository ordersRepo;
	
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
	@PostMapping("/addProduct")
	@CrossOrigin(origins="*")
	public Product addProduct(@RequestBody Product product){
		
		return prod_repository.save(product);
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
	


	@PostMapping("/placedOrderNow")
	@CrossOrigin(origins="*")
	public String placeOrder(@RequestBody Orders order) {
		ordersRepo.save(order);
		System.out.println("purchased");
		return "Order placed successfully...";
	}

	@GetMapping("/getUserByName/{email}")
	@CrossOrigin(origins="*")
	public User getUserbyEmail(@PathVariable String email) {
		return service.findEmail(email);
	}

	@GetMapping("/getProducts")
	@CrossOrigin(origins="*")
	public List<Product> getProducts() {
		return prod_repository.findAll();
	}

}
