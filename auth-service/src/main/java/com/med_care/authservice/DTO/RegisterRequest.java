package com.med_care.authservice.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String username; 
	private String password; 
	private String role; 

}
