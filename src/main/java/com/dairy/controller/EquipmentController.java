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
import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.service.EquipmentService;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;

	@GetMapping
	public ResponseEntity<List<EquipmentResponseDto>> getAllEquipments() {
		return new ResponseEntity<>(equipmentService.getAllEquipments(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> createEquipment(@RequestBody EquipmentRequestDto equipmentRequestDto) {
		boolean isAdded = equipmentService.createEquipment(equipmentRequestDto);
		if (isAdded)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_EQIPMENT_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_EQIPMENT_ERROR_MSG);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentResponseDto> findById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findById(id));
	}

	@PutMapping
	public ResponseEntity<String> updateEquipment(@RequestBody EquipmentRequestDto equipmentRequestDto) {
		boolean isUpdated = equipmentService.updateEquipment(equipmentRequestDto);
		if (isUpdated)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_EQIPMENT_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_EQIPMENT_ERROR_MSG);
	}
}
