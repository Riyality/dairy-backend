package com.dairy.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.login.LoginRequestDto;
import com.dairy.dto.login.LoginResponceDto;
import com.dairy.entity.Employee;
import com.dairy.entity.Login;
import com.dairy.mapper.login.LoginMapper;
import com.dairy.repository.EmployeeRepository;
import com.dairy.repository.LoginRepository;
import com.dairy.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public LoginResponceDto login( LoginRequestDto dto ) {
		try {
			Login login = loginRepository.findByUsername( dto.getUsername() );
			if ( login != null && ( login.getPassword().equals( dto.getPassword() ) && login.getRole().equals( "Owner" ) ) ) {
				Employee employee = employeeRepository.findByContact( dto.getUsername() );
				LoginResponceDto response = loginMapper.toLoginResponseDto( login );
				response.setBranchId( employee.getBranch().getId() );
				response.setBranchName( employee.getBranch().getName() );
				response.setLoginId( employee.getId() );
				log.info( dto.getUsername() + " user logged IN at " + LocalDate.now() );
				return response;

			}
		} catch ( Exception e ) {
			log.error( e.getMessage(), e );
		}
		return null;
	}

}
