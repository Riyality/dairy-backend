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
import com.dairy.dto.feedtype.FeedTypeRequestDto;
import com.dairy.dto.feedtype.FeedTypeResponseDto;
import com.dairy.service.FeedTypeService;

@RestController
@RequestMapping("/feedtype")
public class FeedTypeController {

	@Autowired
	FeedTypeService feedTypeService;

	@PostMapping
	public ResponseEntity<String> addfeed(@RequestBody FeedTypeRequestDto dto) {
		boolean isAdded = feedTypeService.addFeed(dto);
		if (isAdded)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_FEEDTYPE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_FEEDTYPE_ERROR_MSG);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FeedTypeResponseDto> getFeedType(@PathVariable Long id) {
		FeedTypeResponseDto feedTypeResponseDto = feedTypeService.findById(id);

		return ResponseEntity.status(HttpStatus.OK).body(feedTypeResponseDto);

	}

	@GetMapping()
	public ResponseEntity<List<FeedTypeResponseDto>> getAllFeedTypes() {
		return new ResponseEntity<>(feedTypeService.getAllFeedTypes(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}/branchId/{branchId}")
	public ResponseEntity<List<FeedTypeResponseDto>> getFeedTypeByFeedCompanyId(@PathVariable long id, @PathVariable int branchId) {
		return new ResponseEntity<>(feedTypeService.getFeedTypeByFeedCompanyId(id, branchId), HttpStatus.OK);
	}
	

	/*
	 * @GetMapping("getFeedTypeByFeedCompanyId/{id}") public
	 * ResponseEntity<List<FeedTypeResponseDto>>
	 * getFeedTypeByFeedCompanyId(@PathVariable Long id) { return new
	 * ResponseEntity<>(feedTypeService.getFeedTypeByFeedCompanyId(id),
	 * HttpStatus.OK); }
	 */

	@PutMapping
	public ResponseEntity<String> updatefeed(@RequestBody FeedTypeRequestDto dto) {
		boolean update = feedTypeService.updateFeed(dto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_FEEDTYPE_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_FEEDTYPE_ERROR_MSG);
	}	


}
