package com.dairy.service;

import java.util.List;

import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.entity.Bank;

public interface EmployeeService {

	boolean addEmployee(EmployeeRequestDto employeeRequestDto, Bank bank);

	List<EmployeeResponseDto> getAllEmplyoee();

	boolean updateEmployee(EmployeeRequestDto employeeRequestDto, Bank bank);

	EmployeeResponseDto findById( Long id );

	

}
