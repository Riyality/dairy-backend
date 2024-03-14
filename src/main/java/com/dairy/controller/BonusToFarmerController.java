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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;
import com.dairy.service.BonusToFarmerService;

@RestController
@RequestMapping("/bonusToFarmers")
public class BonusToFarmerController {
	@Autowired
	private BonusToFarmerService bonusToFarmerService;

	@PostMapping
	public ResponseEntity<String> addBonus(@RequestBody BonusToFarmerRequestDto bonusToFarmerRequestDto) {

		boolean isAdded = bonusToFarmerService.addBonus(bonusToFarmerRequestDto);
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_BONUS_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_BONUS_ERROR_MSG );
	}

	
	
	 @GetMapping("/branch/{id}")
    public ResponseEntity<List<BonusToFarmerResponseDto>> getRecordOfBonus(@PathVariable int id) {
		 	
		 return new ResponseEntity<>( bonusToFarmerService.findAllBonusStatus( id ), HttpStatus.OK );
    }
	 
	 @GetMapping("/datewise/{fromDate}/{toDate}/{branchId}/{flag}")
		public ResponseEntity<List<BonusToFarmerResponseDto>> getBonusRecordsDatewise(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
		        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,@PathVariable int branchId,@PathVariable String flag) {
			return new ResponseEntity<>(bonusToFarmerService.getBonusRecordsDatewise(fromDate,toDate,branchId,flag), HttpStatus.OK);
		}
	 
	

}
