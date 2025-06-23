package com.med_care.authservice.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponse {
	
	private String token; 
	private String role; 

}
