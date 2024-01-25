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
import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;
import com.dairy.service.FeedToFarmerService;

@RestController
@RequestMapping("/feedTofarmers")
public class FeedToFarmerController {
	@Autowired
	FeedToFarmerService feedToFarmerService;

	@GetMapping
	public ResponseEntity<List<FeedToFarmerResponseDto>> getAllFeedToFarmer() {
		return new ResponseEntity<>(feedToFarmerService.getAllFeedToFarmer(), HttpStatus.OK);

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
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody FeedToFarmerRequestDto feedToFarmerRequestDto){
		boolean update=feedToFarmerService.updateFeedToFarmer(feedToFarmerRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_FEEDTOFARMER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_FEEDTOFARMER_ERROR_MSG);
		
	}

}
