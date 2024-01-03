package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.entity.Bank;
import com.dairy.service.BankService;
import com.dairy.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private BankService bankService;

	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
		Bank bank = bankService.addBank(employeeRequestDto.getBankRequestDto());

		boolean addEmp = employeeService.addEmployee(employeeRequestDto, bank);
		if (addEmp)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_EMPLOYEE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_EMPLOYEE_ERROR_MSG);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmplyoee() {

		return new ResponseEntity<>(employeeService.getAllEmplyoee(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
		Bank bank = bankService.updateBank(employeeRequestDto.getBankRequestDto());

		boolean isUpdated = employeeService.updateEmployee(employeeRequestDto, bank);

		if (isUpdated)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_EMPLOYEE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_EMPLOYEE_ERROR_MSG);
	}

}