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
public class LoginRequestDto {
	private int id;
	@NotBlank(message = "username cannot be blank")
	private String username;
	@NotBlank(message = "password cannot be blank")
	private String password;
	private String role;
	private String name;
}
