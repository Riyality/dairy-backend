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
import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingRequestDto;
import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingResponseDto;
import com.dairy.service.FarmerAnimalMappingService;

@RestController
@RequestMapping("/farmerAnimalMapping")
public class FarmerAnimalMappingController {
	@Autowired
	private FarmerAnimalMappingService farmerAnimalMappingService;

	@GetMapping
	public ResponseEntity<List<FarmerAnimalMappingResponseDto>> getAllAnimal() {
		return new ResponseEntity<>(farmerAnimalMappingService.getAllAnimal(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createAnimal(@RequestBody FarmerAnimalMappingRequestDto reqDto) {
		boolean isAdded = farmerAnimalMappingService.createAnimal(reqDto);
		if (isAdded)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_ANIMAL_MAPPING_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_ANIMAL_MAPPING_ERROR_MSG);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FarmerAnimalMappingResponseDto> findById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(farmerAnimalMappingService.findById(id));
	}

	@PutMapping
	public ResponseEntity<String> updateAnimal(@RequestBody FarmerAnimalMappingRequestDto dto) {
		boolean isUpdated = farmerAnimalMappingService.updateAnimal(dto);
		if (isUpdated)
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(MessageConstants.UPDATE_ANIMAL_MAPPING_ERROR_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(MessageConstants.UPDATE_ANIMAL_MAPPING_ERRORT_ERROR_MSG);
	}

}
