
package com.dairy.service;

import java.util.List;

import com.dairy.dto.feedStock.FeedStockRequestDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;

public interface FeedStockService {

	boolean addFeedStock(FeedStockRequestDto feedStockRequestDto);

	List<FeedStockResponseDto> getAllFeed(int branchId);

	FeedStockResponseDto findById(int id ,int branchId);

	boolean updateFeedStock(FeedStockRequestDto feedStockRequestDto);
  
  	int getTotalQuantityByBranch(int branchId);

}