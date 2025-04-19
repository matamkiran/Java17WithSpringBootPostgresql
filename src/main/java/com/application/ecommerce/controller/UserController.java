package com.application.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.ecommerce.model.LoginRequest;
import com.application.ecommerce.model.LoginResponse;
import com.application.ecommerce.model.RegisterResponse;
import com.application.ecommerce.model.User;
import com.application.ecommerce.service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/*
	 * @Autowired private ProductService productService;
	 * 
	 * @GetMapping("/products/all") public List<Product> getAllProduct(){ return
	 * null; //productService.getAllProducts(); }
	 */
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> registerUser(@RequestBody User user) {
		RegisterResponse response= userService.registerUser(user);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
		LoginResponse loginResponse=userService.verify(loginRequest);
		return ResponseEntity.ok(loginResponse);
	}
}	
