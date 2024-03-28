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
import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;
import com.dairy.entity.FeedToFarmer;
import com.dairy.service.FeedToFarmerService;

@RestController
@RequestMapping("/feedTofarmers")
public class FeedToFarmerController {
	@Autowired
	FeedToFarmerService feedToFarmerService;

	@GetMapping("/branch/{branchId}")
	public ResponseEntity<List<FeedToFarmerResponseDto>> getAllFeedToFarmer(@PathVariable int branchId) {
		return new ResponseEntity<>(feedToFarmerService.getAllFeedToFarmer(branchId), HttpStatus.OK);

	}
	
	
	@PostMapping
	public ResponseEntity<String> addFeedToFarmer(@RequestBody FeedToFarmerRequestDto feedToFarmerReqDto) {
		boolean add = feedToFarmerService.addFeedToFarmer(feedToFarmerReqDto);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_FEEDTOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_FEEDTOFARMER_ERROR_MSG);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FeedToFarmerResponseDto> findById(@PathVariable long id){
		return  ResponseEntity.status( HttpStatus.OK ).body( feedToFarmerService.findByIdFeedTOFarmer( id ) );
		
	}

	@GetMapping("/{farmerId}/{branchId}/{fromDate}/{toDate}")
	public ResponseEntity<Double> findTotalOfRemainingAmountByFarmerIdAndBranchId(
	        @PathVariable("farmerId") Long farmerId, @PathVariable("branchId") int branchId,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
		
	    Double result = feedToFarmerService.findTotalOfRemainingAmountByFarmerIdAndBranchId(farmerId, branchId,fromDate,toDate);

	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/farmerId/{farmerId}")
	public ResponseEntity<FeedToFarmer> findByFarmerId(
	        @PathVariable("farmerId") Long farmerId) {
		
	    FeedToFarmer result = feedToFarmerService.findByFarmerId(farmerId);
	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	

	@GetMapping("/farmerIds/{farmerId}")
	public ResponseEntity<List<FeedToFarmer>> getFarmersByFarmerId(
	        @PathVariable("farmerId") Long farmerId) {
		
	    List<FeedToFarmer> result = feedToFarmerService.getFarmersByFarmerId(farmerId);
	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody FeedToFarmerRequestDto feedToFarmerRequestDto){
		boolean update=feedToFarmerService.updateFeedToFarmer(feedToFarmerRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_FEEDTOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_FEEDTOFARMER_ERROR_MSG);
		
	}
	
	@GetMapping("/datewiseFeed/{fromDate}/{toDate}/{branchId}/{flag}")
	public ResponseEntity<List<FeedToFarmerResponseDto>> getRecordsDatewise( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,@PathVariable int branchId,@PathVariable String flag) {
		
	    List<FeedToFarmerResponseDto> result = feedToFarmerService.getRecordsDatewise(fromDate,toDate,branchId,flag);
	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	

	
	
	
	
}
