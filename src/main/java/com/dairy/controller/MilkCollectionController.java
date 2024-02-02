package com.dairy.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
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
	
	@GetMapping("/branchId/{branchId}/dateOfCollection/{dateOfCollection}")
	public ResponseEntity<List<MilkCollectionResponseDto>> getAllMilkCollectionDataByDate(
	    @PathVariable int branchId,
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfCollection) {
	    
	    List<MilkCollectionResponseDto> milkCollectionData = 
	        milkCollectionService.findAllByBranchIdAndDateOfCollection(branchId, dateOfCollection);
	  
	    return new ResponseEntity<>(milkCollectionData, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addMilkCollectionData( @RequestBody MilkCollectionRequestDto milkCollectionRequestDto ) {
		boolean isAdded = milkCollectionService.addMilkCollectionData( milkCollectionRequestDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_BRANCH_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_BRANCH_ERROR_MSG );
	}
	
	
	 @GetMapping("/{fromDate}/{toDate}/{animalType}")
	    public ResponseEntity<List<MilkCollectionResponseDto>> findByFromDateAndToDateAndAnimalType(
	            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
	            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,
	            @PathVariable String animalType) {
		 List<Object[]> totalAmountResults = milkCollectionService.findByDateAndTypeAndSumTotalAmountByFarmer(fromDate, toDate, animalType);
		 // Create a map to easily access the total amount and total quantity by farmer ID
		 Map<Long, MilkCollectionResponseDto> totalAmountAndQuantityMap = new HashMap<>();
		 for (Object[] result1 : totalAmountResults) {
		     Farmer farmer = (Farmer) result1[0];
		     Branch branch=(Branch)result1[1];
		     Double sumTotalAmount = (Double) result1[2]; // Assuming sumTotalAmount is Double
		     Double sumQuantity = (Double) result1[2]; // Assuming sumQuantity is Double
		     Long farmerId = farmer.getId();
		     String branchName=branch.getName();
		     // Create or update MilkCollectionResponseDto in the map
		     MilkCollectionResponseDto dto = totalAmountAndQuantityMap.getOrDefault(farmerId, new MilkCollectionResponseDto());
		     dto.setFarmerId(farmerId);
		     dto.setFarmerName(farmer.getName()); // Assuming there's a method to get the farmer name
		     dto.setTotalMilkAmount( sumTotalAmount.floatValue());
		     dto.setMilkQuantity( sumQuantity.floatValue());
		     dto.setBranchName(branchName); // System.out.println(branchName);
		     totalAmountAndQuantityMap.put(farmerId, dto);
		 }
		 // Ensure unique farmer IDs in the result list
		 Set<Long> uniqueFarmerIds = new HashSet<>();
		 List<MilkCollectionResponseDto> uniqueResult = new ArrayList<>();
		 for (MilkCollectionResponseDto dto : totalAmountAndQuantityMap.values()) {
		     Long farmerId = dto.getFarmerId();
		     if (uniqueFarmerIds.add(farmerId)) {
		         uniqueResult.add(dto);
		     }
		 }
	    return new ResponseEntity<>(uniqueResult, HttpStatus.OK);
	}
		
	 	 
	  @GetMapping("getMilkCollectionDataBy/{farmerId}")
	    public ResponseEntity<List<MilkCollectionResponseDto>> getRecordsByFarmerId(@PathVariable Long farmerId) {
		
	        List<MilkCollectionResponseDto> responseDtos = milkCollectionService.getRecordsByFarmerId(farmerId);
	        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
	    }



	
}
