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
import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.service.BranchService;

@RestController
@RequestMapping( "/branches" )
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping
	public ResponseEntity<List<BranchResponseDto>> getAllBranches() {
		return new ResponseEntity<>( branchService.getAllBranches(), HttpStatus.OK );
	}

	@PostMapping
	public ResponseEntity<String> createBranch( @RequestBody BranchRequestDto branchRequestDto ) {
		boolean isAdded = branchService.createBranch( branchRequestDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_BRANCH_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_BRANCH_ERROR_MSG );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity<BranchResponseDto> findById( @PathVariable int id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( branchService.findById( id ) );
	}

	@PutMapping
	public ResponseEntity<String> updateBranch( @RequestBody BranchRequestDto dto ) {
		boolean isUpdated = branchService.updateBranch( dto );
		if ( isUpdated )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_BRANCH_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_BRANCH_ERROR_MSG );
	}
}
