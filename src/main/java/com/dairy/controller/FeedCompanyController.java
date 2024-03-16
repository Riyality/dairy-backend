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
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;
import com.dairy.service.FeedCompanyService;



@RestController
@RequestMapping("/feedcompany")
public class FeedCompanyController {

	@Autowired
	private FeedCompanyService feedCompanyService;
	
	@PostMapping
	public ResponseEntity<String> addFeedCompany(@RequestBody FeedCompanyRequestDto dto) {
		boolean isAdded =feedCompanyService.addFeedCompany(dto);
	
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_FEEDCOMPANY_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_FEEDCOMPANY_ERROR_MESSAGE );
	}
	
	@GetMapping("/{id}/{branchId}")
	public ResponseEntity<FeedCompanyResponseDto> findById(@PathVariable long id ,@PathVariable int branchId) {
		FeedCompanyResponseDto responseDto = feedCompanyService.findById(id ,branchId);
		return ResponseEntity.status( HttpStatus.OK ).body(responseDto);
	}
	
	@GetMapping("all/{branchId}")
	public ResponseEntity<List<FeedCompanyResponseDto>> findAll(@PathVariable int branchId) {
		return new ResponseEntity<>( feedCompanyService.findAll(branchId), HttpStatus.OK );
	}
	
	@PutMapping
	public ResponseEntity<String> updateFeedCompany(@RequestBody FeedCompanyRequestDto requestDto){
		boolean upate=feedCompanyService.updateFeedCompany(requestDto);
		if ( upate )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_FEEDCOMPANY_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_FEEDCOMPANY_ERROR_MESSAGE );
	}
	
	 @PostMapping("/saveAll")
		public ResponseEntity<FeedCompanyRequestDto> saveAllFeedCompanyList(@RequestBody List<FeedCompanyRequestDto> dto) {
		 FeedCompanyRequestDto FeedCompanyRequestDto = feedCompanyService.saveAllFeedCompanyList(dto);
		   
		    if (FeedCompanyRequestDto != null) {
		        return ResponseEntity.status(HttpStatus.CREATED).body(FeedCompanyRequestDto);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
		}
		
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

