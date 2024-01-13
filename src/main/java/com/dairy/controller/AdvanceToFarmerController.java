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
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerRequestDto;
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerResponseDto;
import com.dairy.service.AdvanceToFarmerService;

@RestController
@RequestMapping("/advanceToFarmer")
public class AdvanceToFarmerController {

	@Autowired
	AdvanceToFarmerService advanceToFarmerService;

	@PostMapping
	public ResponseEntity<String> addAdvance(@RequestBody AdvanceToFarmerRequestDto advanceRequestDto) {
		boolean added = advanceToFarmerService.addAdvance(advanceRequestDto);
		if (added)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_ADVANCETOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_ADVANCETOFARMER_ERROR_MSG);
	}

	@GetMapping
	public ResponseEntity<List<AdvanceToFarmerResponseDto>> getAllAdvance() {
		return new ResponseEntity<>(advanceToFarmerService.getAllAdvanceToFarmer(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<AdvanceToFarmerResponseDto> findById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(advanceToFarmerService.findById(id));
	}

	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody AdvanceToFarmerRequestDto advanceRequestDto){
		boolean update = advanceToFarmerService.updateAdvance(advanceRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_ADVANCETOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_ADVANCETOFARMER_ERROR_MSG);
	}
}