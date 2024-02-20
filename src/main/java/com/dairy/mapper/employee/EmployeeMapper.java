package com.dairy.mapper.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.entity.Employee;

@Component
public class EmployeeMapper {

	public Employee toEntity(EmployeeRequestDto employeeRequestDto) {
		
		if (employeeRequestDto == null) {
			return null;
		}

		Employee employee = new Employee();
		employee.setId(employeeRequestDto.getId());
		employee.setName(employeeRequestDto.getName());
		employee.setContact(employeeRequestDto.getContact());
		employee.setAddress(employeeRequestDto.getAddress());
		employee.setDateOfJoining(employeeRequestDto.getDateOfJoining());
		employee.setRemark(employeeRequestDto.getRemark());
		employee.setRole(employeeRequestDto.getRole());

		return employee;
	}

	public EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
		if (employee == null) {
			return null;
		}

		EmployeeResponseDto responseDto = new EmployeeResponseDto();
		responseDto.setId(employee.getId());
		responseDto.setName(employee.getName());
		responseDto.setContact(employee.getContact());
		responseDto.setAddress(employee.getAddress());
		responseDto.setDateOfJoining(employee.getDateOfJoining());
		responseDto.setRemark(employee.getRemark());
		responseDto.setRole(employee.getRole());

		if (employee.getBranch() != null) {
			responseDto.setBranchId(employee.getBranch().getId());
			responseDto.setBranchName(employee.getBranch().getName());
		}

		if (employee.getBank() != null) {
			responseDto.setBankId(employee.getBank().getId());
			responseDto.setBankName(employee.getBank().getBankName());
			responseDto.setIfscCode(employee.getBank().getIfscCode());
			responseDto.setBankBranchName(employee.getBank().getBranchName());
			responseDto.setAccountNumber(employee.getBank().getAccountNumber());
			responseDto.setUpiId(employee.getBank().getUpiId());

		}

		return responseDto;
	}

	public List<EmployeeResponseDto> toList(List<Employee> list) {
		List<EmployeeResponseDto> dtos = new ArrayList<>();
		for (Employee entity : list) {
			dtos.add(toEmployeeResponseDto(entity));
		}
		return dtos;
	}
}
