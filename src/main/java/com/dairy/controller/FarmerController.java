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
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.service.FarmerService;

@RestController
@RequestMapping( "/farmers" )
public class FarmerController {

	@Autowired
	private FarmerService farmerService;

	@PostMapping
	public ResponseEntity<String> add( @RequestBody FarmerRequestDto dto ) {
		boolean isAdded = farmerService.add( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_FARMER_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_FARMER_ERROR_MSG );
	}

	@GetMapping( "/id/{id}" )
	public ResponseEntity<FarmerResponseDto> findById( @PathVariable Long id ) {
		return new ResponseEntity<>( farmerService.findById( id ), HttpStatus.OK );
	}

	@GetMapping( "/branch/{id}" )
	public ResponseEntity<List<FarmerResponseDto>> allActiveFarmers( @PathVariable int id ) {
		return new ResponseEntity<>( farmerService.findAllActive( id ), HttpStatus.OK );
	}

	@GetMapping( "/branch/{branchId}/route/{routeId}" )
	public ResponseEntity<List<FarmerResponseDto>> farmersListByRoute( @PathVariable int branchId, @PathVariable int routeId) {
		return new ResponseEntity<>( farmerService.farmersListByRoute( branchId, routeId ), HttpStatus.OK );
	}

}
