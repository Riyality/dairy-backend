package com.dairy.service;

import com.dairy.dto.login.LoginRequestDto;
import com.dairy.dto.login.LoginResponceDto;

public interface LoginService {

	public LoginResponceDto login( LoginRequestDto dto );
}
