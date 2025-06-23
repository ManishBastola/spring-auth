package com.med_care.authservice.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

	private String username; 
	private String password; 
}
