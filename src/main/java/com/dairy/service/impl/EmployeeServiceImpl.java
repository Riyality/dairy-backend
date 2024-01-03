package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Employee;
import com.dairy.mapper.employee.EmployeeMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.EmployeeRepository;
import com.dairy.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public boolean addEmployee(EmployeeRequestDto employeeRequestDto, Bank bank) {

		try {
			Employee employee = employeeMapper.toEntity(employeeRequestDto);
			employee.setBank(bank);
			Optional<Branch> opt = branchRepository.findById(employeeRequestDto.getBranchId());
			if (opt.isPresent())
				employee.setBranch(opt.get());
			employeeRepository.save(employee);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<EmployeeResponseDto> getAllEmplyoee() {

		List<Employee> employee = employeeRepository.findAll();
		return employeeMapper.toList(employee);
	}

	@Override
	public boolean updateEmployee(EmployeeRequestDto employeeRequestDto, Bank bank) {

		try {
			Employee employee = employeeMapper.toEntity(employeeRequestDto);
			employee.setBank(bank);
			Optional<Branch> opt = branchRepository.findById(employeeRequestDto.getBranchId());
			if (opt.isPresent())
				employee.setBranch(opt.get());
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public EmployeeResponseDto findById(Long id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		if (opt.isPresent())
			return employeeMapper.toEmployeeResponseDto(opt.get());
		return null;
	}
}
