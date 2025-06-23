package com.med_care.authservice.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String Username; 
	private String password; 
	private String Role; 

}
