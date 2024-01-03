package com.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.dto.login.LoginRequestDto;
import com.dairy.dto.login.LoginResponceDto;
import com.dairy.service.LoginService;

@RestController
@RequestMapping( "/logins" )
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<LoginResponceDto> login( @RequestBody LoginRequestDto dto ) {
		LoginResponceDto response = loginService.login( dto );
		return ResponseEntity.status( HttpStatus.OK ).body( response );
	}
}
