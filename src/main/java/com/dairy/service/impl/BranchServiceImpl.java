package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Employee;
import com.dairy.entity.Login;
import com.dairy.mapper.branch.BranchMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.EmployeeRepository;
import com.dairy.repository.LoginRepository;
import com.dairy.service.BranchService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private BranchMapper branchMapper;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<BranchResponseDto> getAllBranches() {
		List<Branch> branches = branchRepository.findAll();
		return branchMapper.toList( branches );
	}

	@Override
	public boolean createBranch( BranchRequestDto dto ) {
		try {
			Branch branch = branchMapper.toEntity( dto );
			Branch addedBranch = branchRepository.save( branch );

			Login login = new Login( 0, dto.getOwnerContact(), "Demo_1234", "Owner", dto.getOwner() );
			loginRepository.save( login );

			Employee employee = new Employee();
			employee.setName( dto.getOwner() );
			employee.setBranch( addedBranch );
			employee.setContact( dto.getOwnerContact() );
			employee.setDateOfJoining( dto.getStartDate() );
			employee.setAddress( dto.getAddress() );
			employeeRepository.save( employee );

			return true;

		} catch ( Exception e ) {
			log.error( e.getMessage(), e );
		}
		return false;
	}

	@Override
	public BranchResponseDto findById( int id ) {
		Optional<Branch> opt = branchRepository.findById( id );
		if ( opt.isPresent() )
			return branchMapper.toBranchResponseDto( opt.get() );
		return null;
	}

	@Override
	public boolean updateBranch( BranchRequestDto dto ) {
		try {
			Branch branch = branchMapper.toEntity( dto );
			Branch addedBranch = branchRepository.save( branch );

			Login existingLogin = loginRepository.findByUsername( dto.getOwnerContact() );
			existingLogin.setName( dto.getName() );
			loginRepository.save( existingLogin );

			Employee employee = employeeRepository.findByContact( dto.getOwnerContact() );
			employee.setName( dto.getOwner() );
			employee.setBranch( addedBranch );
			employee.setContact( dto.getOwnerContact() );
			employee.setDateOfJoining( dto.getStartDate() );
			employee.setAddress( dto.getAddress() );
			employeeRepository.save( employee );
			return true;
		} catch ( Exception e ) {
			log.error( e.getMessage(), e );
		}
		return false;
	}
}
