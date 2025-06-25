package com.med_care.authservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med_care.authservice.DTO.ForgotPasswordRequest;
import com.med_care.authservice.DTO.LoginRequest;
import com.med_care.authservice.DTO.LoginResponse;
import com.med_care.authservice.DTO.RegisterRequest;
import com.med_care.authservice.model.User;
import com.med_care.authservice.service.UserService;

@CrossOrigin(origins = {
	    "http://localhost:5173",
	    "http://localhost:3000",
	    "https://zippy-palmier-57f961.netlify.app",
	    "https://imaginative-marshmallow-ae6713.netlify.app"
	})
@RestController
@RequestMapping("/api/auth")
public class UserController {

	
	
	@Autowired
	public UserService userService; 
	
	
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody  LoginRequest request ) {
		return userService.login(request);
	}
	
	
	@PostMapping("/register")
	public User register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	
	@PostMapping("/forgot-password")
	public User forgotPassword(@RequestBody ForgotPasswordRequest request) {
		return userService.forgotPassword(request);
	}
	
	@GetMapping("/test/user")
	public ResponseEntity<String> testJwt(Authentication authentication) {
	    String username = authentication.getName();
	    return ResponseEntity.ok("JWT Token is valid. usename is :  " + username + "");
	}


}
