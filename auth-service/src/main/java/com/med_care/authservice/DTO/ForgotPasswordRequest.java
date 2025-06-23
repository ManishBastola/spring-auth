package com.med_care.authservice.DTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPasswordRequest {

	public String password; 
	public String  username; 
	
}
