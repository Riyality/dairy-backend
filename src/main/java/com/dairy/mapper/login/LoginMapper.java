package com.dairy.mapper.login;

import org.springframework.stereotype.Component;

import com.dairy.dto.login.LoginRequestDto;
import com.dairy.dto.login.LoginResponceDto;
import com.dairy.entity.Login;

@Component
public class LoginMapper {

	public Login toEntity( LoginRequestDto loginRequestDto ) {
		if ( loginRequestDto == null ) {
			return null;
		}

		Login login = new Login();
		login.setId( loginRequestDto.getId() );
		login.setUsername( loginRequestDto.getUsername() );
		login.setPassword( loginRequestDto.getPassword() );
		login.setRole( loginRequestDto.getRole() );
		login.setName( loginRequestDto.getName() );

		return login;
	}

	public LoginResponceDto toLoginResponseDto( Login login ) {
		if ( login == null ) {
			return null;
		}

		LoginResponceDto loginResponseDto = new LoginResponceDto();
		loginResponseDto.setId( login.getId() );
		loginResponseDto.setName( login.getName() );
		loginResponseDto.setUsername( login.getUsername() );
		loginResponseDto.setRole( login.getRole() );

		return loginResponseDto;
	}
}
