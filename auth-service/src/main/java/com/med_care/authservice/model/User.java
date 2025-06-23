package com.med_care.authservice.model;

import jakarta.persistence.*;
import lombok.*; 

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String username; 
	
	private String password; 
	
	@Enumerated(EnumType.STRING)
	private Role role; 
	
}
