package com.dairy.dto.login;

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
	private String username;
	private String password;
	private String role;
	private String name;
}
