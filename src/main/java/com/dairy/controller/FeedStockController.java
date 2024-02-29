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
import com.dairy.dto.feedStock.FeedStockRequestDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;
import com.dairy.service.FeedStockService;

@RestController
@RequestMapping("/feedStock")
public class FeedStockController {
	@Autowired
	FeedStockService feedStockService;

	@PostMapping
	public ResponseEntity<String> addFeedStock(@RequestBody FeedStockRequestDto feedStockRequestDto) {
		boolean add = feedStockService.addFeedStock(feedStockRequestDto);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_FEEDSTOCK_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_FEEDSTOCK_ERROR_MSG);
	
	}

	@GetMapping
	public ResponseEntity<List<FeedStockResponseDto>> getAllFeed() {

		return new ResponseEntity<>(feedStockService.getAllFeed(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FeedStockResponseDto> findById(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(feedStockService.findById(id));
		
	}
	
	@PutMapping()
	public ResponseEntity<String>  update(@RequestBody FeedStockRequestDto feedStockRequestDto){
		boolean update=feedStockService.updateFeedStock(feedStockRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_FEEDSTOCK_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_FEEDSTOCK_ERROR_MSG);
	}
	
	/* @GetMapping("/count")
	    public ResponseEntity<Integer> getTotalFeedStockCount() {
	        int count = feedStockService.getTotalFeedStockCount();
	        return ResponseEntity.ok(count);
	    }*/
	
/*	@GetMapping("/totalQuantity/branch/{branchId}")
    public ResponseEntity<Integer> getTotalQuantityByBranch(@PathVariable int branchId) {
        int totalQuantity = feedStockService.getTotalQuantityByBranch(branchId);
        return ResponseEntity.ok(totalQuantity);
    }*/
	@GetMapping("/totalQuantity/branch/{branchId}")
	public long getTotalQuantityByBranch(@PathVariable int branchId) {
	    return feedStockService.getTotalQuantityByBranch(branchId);
	}

}
