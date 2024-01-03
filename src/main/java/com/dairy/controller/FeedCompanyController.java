package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
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
	
	@GetMapping("/id/{id}")
	public ResponseEntity<FeedCompanyResponseDto> findById(@PathVariable Long id) {
		FeedCompanyResponseDto responseDto = feedCompanyService.findById(id);
		return ResponseEntity.status( HttpStatus.OK ).body(responseDto);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<FeedCompanyResponseDto>> findAll() {
		return new ResponseEntity<>( feedCompanyService.findAll(), HttpStatus.OK );
	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

