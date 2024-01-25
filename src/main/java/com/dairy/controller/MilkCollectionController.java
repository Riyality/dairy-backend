package com.dairy.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.dairy.entity.Farmer;
import com.dairy.repository.MilkCollectionRepository;
import com.dairy.service.MilkCollectionService;

@RestController
@RequestMapping( "/milkCollection" )
public class MilkCollectionController {

	
	@Autowired
	private MilkCollectionService milkCollectionService;

	@PostMapping
	public ResponseEntity<String> addMilkCollectionData( @RequestBody MilkCollectionRequestDto milkCollectionRequestDto ) {
		boolean isAdded = milkCollectionService.addMilkCollectionData( milkCollectionRequestDto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_BRANCH_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_BRANCH_ERROR_MSG );
	}
	
	
	@GetMapping
	public ResponseEntity<List<MilkCollectionResponseDto>> getAllMilkCollectionData() {
		return new ResponseEntity<>( milkCollectionService.getAllMilkCollectionData(), HttpStatus.OK );
	}
	
	 @GetMapping("/{fromDate}/{toDate}/{animalType}")
	    public ResponseEntity<List<MilkCollectionResponseDto>> findByFromDateAndToDateAndAnimalType(
	            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
	            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
	            @PathVariable String animalType) {
		 List<Object[]> totalAmountResults = milkCollectionService.findByDateAndTypeAndSumTotalAmountByFarmer(fromDate, toDate, animalType);

		 System.out.println("totalAmountResults::" + totalAmountResults);

		 // Create a map to easily access the total amount and total quantity by farmer ID
		 Map<Long, MilkCollectionResponseDto> totalAmountAndQuantityMap = new HashMap<>();
		 for (Object[] result1 : totalAmountResults) {
		     Farmer farmer = (Farmer) result1[0];
		     Double sumTotalAmount = (Double) result1[1]; // Assuming sumTotalAmount is Double
		     Double sumQuantity = (Double) result1[2]; // Assuming sumQuantity is Double
		     Long farmerId = farmer.getId();

		     // Create or update MilkCollectionResponseDto in the map
		     MilkCollectionResponseDto dto = totalAmountAndQuantityMap.getOrDefault(farmerId, new MilkCollectionResponseDto());
		     dto.setFarmerId(farmerId);
		     dto.setFarmerName(farmer.getName()); // Assuming there's a method to get the farmer name
		     dto.setTotalMilkAmount( sumTotalAmount.floatValue());
		     dto.setMilkQuantity( sumQuantity.floatValue());
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

		 System.out.println(uniqueResult);
	    return new ResponseEntity<>(uniqueResult, HttpStatus.OK);
	}
		 
//		 
//	 @GetMapping("getMilkCollectionDataBy/{farmerId}")
//	    public ResponseEntity<List<MilkCollectionResponseDto>> getAllMilkCollectionDataByFarmerId( @PathVariable int farmerId){
//		
//		 return ResponseEntity.status(HttpStatus.OK).body(milkCollectionService.getAllMilkCollectionDataByFarmerId(farmerId));
//	 }	 
//		

	 
		
	 


	
}
