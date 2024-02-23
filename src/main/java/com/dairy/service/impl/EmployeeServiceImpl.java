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
import com.dairy.mapper.bank.BankMapper;
import com.dairy.mapper.employee.EmployeeMapper;
import com.dairy.repository.BankRepository;
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
	private BankMapper bankMapper;

	@Autowired
	private BankRepository bankRepository;

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
	public List<EmployeeResponseDto> getAllEmplyoee(int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
				List<Employee> employee = employeeRepository.findByBranch( branchOptional.get() );
				return employeeMapper.toList(employee);
		}
		return null;
	}

	@Override
	public boolean updateEmployee(EmployeeRequestDto employeeRequestDto) {

		try {
			

			Bank bank = bankMapper.toEntity(employeeRequestDto.getBankRequestDto());
			Optional<Branch> opt = branchRepository.findById(employeeRequestDto.getBranchId());
			if (opt.isPresent())
				bank.setBranch(opt.get());
			
				Bank addedBank = bankRepository.save(bank);
			
				Employee employee = employeeMapper.toEntity(employeeRequestDto);
				employee.setBank(addedBank);
			
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
	public EmployeeResponseDto findById(Long id ,int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if(branchOptional.isPresent()) {
			Optional<Employee> opt = employeeRepository.findByIdAndBranch(id ,branchOptional.get());
			return employeeMapper.toEmployeeResponseDto(opt.get());
		}
		return null;
	}
}
