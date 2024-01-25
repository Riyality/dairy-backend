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
import com.dairy.dto.dairyManger.DairyManagerRequestDto;
import com.dairy.dto.dairyManger.DairyManagerResponseDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesRequestDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesResponseDto;
import com.dairy.service.DairyManagerService;

@RestController
@RequestMapping("/dairyManger")
public class DairyManagerController {

	@Autowired
	private DairyManagerService dairyManagerService;

	@PostMapping
	public ResponseEntity<String> add(@RequestBody DairyManagerRequestDto dto) {
		boolean add = dairyManagerService.add(dto);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_DAIRTY_MANGER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_DAIRTY_MANGER_ERROR_MSG);
	}

	@GetMapping
	public ResponseEntity<List<DairyManagerResponseDto>> getAll() {
		return new ResponseEntity<>(dairyManagerService.getAllDairy(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<DairyManagerResponseDto> getRecordById(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(dairyManagerService.findById(id));
	}

	@PostMapping("/dairyUpdates")
	public ResponseEntity<String> addUpdates(@RequestBody DairyMangerUpdatesRequestDto dto) {
		boolean add = dairyManagerService.addUpdates(dto);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_DAIRTY_MANGER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_DAIRTY_MANGER_ERROR_MSG);
	}

	@GetMapping("/dairyUpdates")
	public ResponseEntity<List<DairyMangerUpdatesResponseDto>> getAllUpdates() {
		return new ResponseEntity<>(dairyManagerService.getAllDairyUpdates(), HttpStatus.OK);

	}

}
