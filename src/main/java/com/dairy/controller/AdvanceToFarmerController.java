package com.dairy.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.dairy.entity.AdvanceToFarmer;
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

	@GetMapping("all/{branchId}")
	public ResponseEntity<List<AdvanceToFarmerResponseDto>> getAllAdvance(@PathVariable int branchId) {
		return new ResponseEntity<>(advanceToFarmerService.getAllAdvanceToFarmer(branchId), HttpStatus.OK);
	}

	@GetMapping("/{id}/branchId/{branchId}")
	public ResponseEntity<AdvanceToFarmerResponseDto> findById(@PathVariable long id ,@PathVariable int branchId) {
		return ResponseEntity.status(HttpStatus.OK).body(advanceToFarmerService.findById(id ,branchId));
	}

	
	@GetMapping("/{farmerId}/{branchId}")
	public ResponseEntity<Double> findTotalOfRemainingAmountByFarmerIdAndBranchId(@PathVariable Long farmerId, @PathVariable int branchId) {
	    Double result = advanceToFarmerService.findTotalOfRemainingAmountByFarmerIdAndBranchId(farmerId, branchId);
	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/farmerId/{farmerId}")
	public ResponseEntity<AdvanceToFarmer> getFarmersByFarmerId(
	        @PathVariable("farmerId") Long farmerId) {
	    AdvanceToFarmer result = advanceToFarmerService.getAdvanceToFarmerByFarmerId(farmerId);
	    
	    if (result != null) {
	        return ResponseEntity.status(HttpStatus.OK).body(result);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody AdvanceToFarmerRequestDto advanceRequestDto){
		boolean update = advanceToFarmerService.updateAdvance(advanceRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_ADVANCETOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_ADVANCETOFARMER_ERROR_MSG);
	}
	
	@GetMapping("datewise/{fromDate}/{toDate}/{branchId}/{flag}")
	public ResponseEntity<List<AdvanceToFarmerResponseDto>> getAdvanceRecordsDatewise(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,@PathVariable int branchId,@PathVariable String flag) {
		return new ResponseEntity<>(advanceToFarmerService.getAdvanceRecordsDatewise(fromDate,toDate,branchId,flag), HttpStatus.OK);
	}
}