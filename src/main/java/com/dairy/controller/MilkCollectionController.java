package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.service.MilkCollectionService;

@RestController
@RequestMapping( "/milkCollection" )
public class MilkCollectionController {

	@Autowired
	private MilkCollectionService milkCollectionService;

	@GetMapping
	public ResponseEntity<List<MilkCollectionResponseDto>> getAllMilkCollectionData() {
		return new ResponseEntity<>( milkCollectionService.getAllMilkCollectionData(), HttpStatus.OK );
	}
	
	@PostMapping
	public ResponseEntity<String> addMilkCollectionData( @RequestBody MilkCollectionRequestDto milkCollectionRequestDto ) {
		boolean isAdded = milkCollectionService.addMilkCollectionData( milkCollectionRequestDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_BRANCH_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_BRANCH_ERROR_MSG );
	}
	
}
