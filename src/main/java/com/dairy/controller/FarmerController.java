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
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.service.FarmerService;

@RestController
@RequestMapping( "/farmers" )
public class FarmerController {

	@Autowired
	private FarmerService farmerService;

	@PostMapping
	public ResponseEntity<String> add( @RequestBody FarmerRequestDto dto ) {
		dto.getBankRequestDto().setBranchId(dto.getBranchId());
		boolean isAdded = farmerService.add( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_FARMER_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_FARMER_ERROR_MSG );
	}

	@GetMapping( "/id/{id}/{branchId}" )
	public ResponseEntity<FarmerResponseDto> findById( @PathVariable Long id , @PathVariable int branchId ) {
		return new ResponseEntity<>( farmerService.findById( id ,branchId ), HttpStatus.OK );
	}

	@GetMapping( "/branch/{id}" )
	public ResponseEntity<List<FarmerResponseDto>> allActiveFarmers( @PathVariable int id ) {
		return new ResponseEntity<>( farmerService.findAllActive( id ), HttpStatus.OK );
	}

	@GetMapping( "/branch/{branchId}/route/{routeId}" )
	public ResponseEntity<List<FarmerResponseDto>> farmersListByRoute( @PathVariable int branchId, @PathVariable int routeId) {
		return new ResponseEntity<>( farmerService.farmersListByRoute( branchId, routeId ), HttpStatus.OK );
	}
	
	@PutMapping
	public ResponseEntity<String> update( @RequestBody FarmerRequestDto dto ) {
		dto.getBankRequestDto().setBranchId(dto.getBranchId());
		boolean update = farmerService.update( dto );
		if ( update )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_FARMER_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_FARMER_ERROR_MSG );
	}

	
	@GetMapping( "/in-ActiveFarmers/branch/{id}" )
	public ResponseEntity<List<FarmerResponseDto>> allInActiveFarmers( @PathVariable int id ) {
		return new ResponseEntity<>( farmerService.findAllInActiveFarmers( id ), HttpStatus.OK );
	}

	
	 @GetMapping("/countActiveFarmers/branch/{branchId}")
	    public long countActiveFarmersByBranchId(@PathVariable int branchId) {
	        return farmerService.countActiveFarmersByBranchId(branchId);
	    }
	 
	 @GetMapping("/countInActiveFarmers/branch/{branchId}")
	    public long countInActiveFarmersByBranchId(@PathVariable int branchId) {
	        return farmerService.countInActiveFarmersByBranchId(branchId);
	    }
	 
	 @PostMapping("/saveAllFarmer")
		public ResponseEntity<FarmerRequestDto> saveAllfarmerList(@RequestBody List<FarmerRequestDto> dto) {
		 FarmerRequestDto FarmerRequestDto = farmerService.saveAllfarmer(dto);
		   
		    if (FarmerRequestDto != null) {
		        return ResponseEntity.status(HttpStatus.CREATED).body(FarmerRequestDto);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
		}

}
