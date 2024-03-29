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
import com.dairy.dto.bankdetails.BankRequestDto;
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
		employeeRequestDto.getBankRequestDto().setBranchId(employeeRequestDto.getBranchId());
		Bank bank = bankService.addBank(employeeRequestDto.getBankRequestDto());

		boolean addEmp = employeeService.addEmployee(employeeRequestDto, bank);
		if (addEmp)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_EMPLOYEE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_EMPLOYEE_ERROR_MSG);
	}

	@GetMapping("all/{branchId}")
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmplyoee(@PathVariable int branchId ) {
		return new ResponseEntity<>(employeeService.getAllEmplyoee(branchId), HttpStatus.OK);
	}

	@GetMapping("{id}/{branchId}")
	public ResponseEntity<EmployeeResponseDto> findById(@PathVariable long id ,@PathVariable int branchId) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id ,branchId));
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
		employeeRequestDto.getBankRequestDto().setBranchId(employeeRequestDto.getBranchId());
		boolean isUpdated = employeeService.updateEmployee(employeeRequestDto);

		if (isUpdated)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_EMPLOYEE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_EMPLOYEE_ERROR_MSG);
	}

}