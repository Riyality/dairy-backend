
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
import com.dairy.dto.feedDetails.FeedDetailsResponseDto;
import com.dairy.dto.feedStock.FeedStockRequestDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;
import com.dairy.service.FeedStockService;

@RestController
@RequestMapping("/feedStock")
public class FeedStockController {
	@Autowired
	FeedStockService feedStockService;

	@PostMapping
	public ResponseEntity<String> addFeedStock(@RequestBody List<FeedStockRequestDto> feedStockRequestDtoList) {
		
		
		boolean add = feedStockService.addFeedStock(feedStockRequestDtoList);
		if (add)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_FEEDSTOCK_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_FEEDSTOCK_ERROR_MSG);
	
	}

	@GetMapping("all/{branchId}")
	public ResponseEntity<List<FeedStockResponseDto>> getAllFeed(@PathVariable int branchId) {
		return new ResponseEntity<>(feedStockService.getAllFeed(branchId), HttpStatus.OK);
	}
	
	@GetMapping("/allFeedDetails/{branchId}")
	public ResponseEntity<List<FeedDetailsResponseDto>> getAllFeedDetails(@PathVariable int branchId) {
		return new ResponseEntity<>(feedStockService.getAllFeedDetails(branchId), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/{branchId}")
	public ResponseEntity<FeedStockResponseDto> findById(@PathVariable int id ,@PathVariable int branchId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(feedStockService.findById(id ,branchId));
		
	}
	

	@GetMapping("feedTypeId/{feedTypeId}/feedCompanyId/{feedCompanyId}/Branch/{branchId}")
	public long getFeedQuantityByFeedTypeFeedCompanyAndBranch(@PathVariable long feedTypeId,
			@PathVariable long feedCompanyId,@PathVariable int branchId) {
		return feedStockService.getFeedQuantityByFeedTypeFeedCompanyAndBranch(feedTypeId,feedCompanyId,branchId);
	}
	
	@PutMapping()
	public ResponseEntity<String>  update(@RequestBody FeedStockRequestDto feedStockRequestDto){
		boolean update=feedStockService.updateFeedStock(feedStockRequestDto);
		if (update)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_FEEDSTOCK_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_FEEDSTOCK_ERROR_MSG);
	}
  	@GetMapping("/totalQuantity/branch/{branchId}")
	public long getTotalQuantityByBranch(@PathVariable int branchId) {
	    return feedStockService.getTotalQuantityByBranch(branchId);
	}

}

