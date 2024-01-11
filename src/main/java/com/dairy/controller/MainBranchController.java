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
import com.dairy.dto.mainBranch.MainBranchRequestDto;
import com.dairy.dto.mainBranch.MainBranchResponseDto;
import com.dairy.service.MainBranchService;

@RestController
@RequestMapping("/mainBranchs")
public class MainBranchController {

	@Autowired
	MainBranchService mainBranchService;

	@PostMapping
	public ResponseEntity<String> addMainBranch(@RequestBody MainBranchRequestDto requestDto) {
		boolean add = mainBranchService.addMainBranch(requestDto);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_MAIN_BRANCH_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_MAIN_BRANCH_ERROR_MESSAGE);

	}

	@GetMapping
	public ResponseEntity<List<MainBranchResponseDto>> getAll() {

		return new ResponseEntity<>(mainBranchService.getAllMainBranch(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<MainBranchResponseDto> findById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(mainBranchService.findByIdMainBranch(id));

	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody MainBranchRequestDto requestDto) {
		boolean update = mainBranchService.updateMainBranch(requestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_MAIN_BRANCH_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(MessageConstants.UPDATE_MAIN_BRANCH_ERROR_MESSAGE);

	}

}
