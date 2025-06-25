package com.med_care.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.med_care.authservice.DTO.ForgotPasswordRequest;
import com.med_care.authservice.DTO.LoginRequest;
import com.med_care.authservice.DTO.LoginResponse;
import com.med_care.authservice.DTO.RegisterRequest;
import com.med_care.authservice.model.Role;
import com.med_care.authservice.model.User;
import com.med_care.authservice.repository.UserRepository;
import com.med_care.authservice.security.JwtUtil;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository; 
	@Autowired
	public PasswordEncoder passwordEncoder; 
	
	@Autowired
	public JwtUtil jwtUtil; 
	
	
	
	public User register(RegisterRequest request) {
		if(userRepository.findByUsername(request.getUsername()).isPresent()){
			throw new RuntimeException("this user is in DB");
		}
		
		String hashedPassword = passwordEncoder.encode(request.getPassword());
		User user = new User(); 
		user.setUsername(request.getUsername());
		user.setPassword(hashedPassword);
		user.setRole(Role.valueOf(request.getRole()));

		return userRepository.save(user);
	}
	
	
	
	public LoginResponse login(LoginRequest request) {
		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new RuntimeException("User No Found")); 
		
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
		    throw new RuntimeException("Incorrect password");
		}

		
		String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name(), user.getId());
		return new LoginResponse(token, user.getRole().name()); 
	}
	
	
	public User forgotPassword(ForgotPasswordRequest request) {

		User user = userRepository.findByUsername(request.getUsername())
		        .orElseThrow(() -> new RuntimeException("Not found"));
		String hashedPassword = passwordEncoder.encode(request.getNewPassword());
user.setPassword(hashedPassword);

		return userRepository.save(user); 
	}
	
	

}
