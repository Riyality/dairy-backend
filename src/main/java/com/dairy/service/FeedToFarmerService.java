package com.dairy.service;

import java.util.List;

import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;

public interface FeedToFarmerService {

	boolean addFeedToFarmer(FeedToFarmerRequestDto feedToFarmerReqDto);

	List<FeedToFarmerResponseDto> getAllFeedToFarmer();

	FeedToFarmerResponseDto findByIdFeedTOFarmer(Long id);

	boolean updateFeedToFarmer(FeedToFarmerRequestDto feedToFarmerRequestDto);

	

}
