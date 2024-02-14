package com.dairy.service;

import java.time.LocalDate;
import java.util.List;

import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;
import com.dairy.entity.FeedToFarmer;

public interface FeedToFarmerService {

	boolean addFeedToFarmer(FeedToFarmerRequestDto feedToFarmerReqDto);

	List<FeedToFarmerResponseDto> getAllFeedToFarmer();

	FeedToFarmerResponseDto findByIdFeedTOFarmer(Long id);

	boolean updateFeedToFarmer(FeedToFarmerRequestDto feedToFarmerRequestDto);
	
	Double findTotalOfRemainingAmountByFarmerIdAndBranchId(long farmerId, int branchId, LocalDate fromDate, LocalDate toDate);

	FeedToFarmer findByFarmerId(Long farmerId);

	List<FeedToFarmer> getFarmersByFarmerId(Long farmerId);

	

}
