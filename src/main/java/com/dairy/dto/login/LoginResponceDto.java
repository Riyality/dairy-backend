package com.dairy.dto.login;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponceDto {
	private int id;
	
	private String name;
	@NotBlank(message = "username cannot be blank")
	private String username;
	
	private String role;
	private String status;
	private int branchId;
	private String branchName;
	private Long loginId;

}
