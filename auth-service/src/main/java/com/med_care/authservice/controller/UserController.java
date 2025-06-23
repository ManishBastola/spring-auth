package com.med_care.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.med_care.authservice.DTO.ForgotPasswordRequest;
import com.med_care.authservice.DTO.LoginRequest;
import com.med_care.authservice.DTO.LoginResponse;
import com.med_care.authservice.DTO.RegisterRequest;
import com.med_care.authservice.model.User;
import com.med_care.authservice.service.UserService;
@RestController
public class UserController {

	
	
	@Autowired
	public UserService userService; 
	
	
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody  LoginRequest request ) {
		return userService.login(request);
	}
	
	
	@PostMapping("/request")
	public User register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	
	@PostMapping("/forgot-password")
	public User forgotPassword(@RequestBody ForgotPasswordRequest request) {
		return userService.forgotPassword(request);
	}
}
