package com.dairy.service;

import java.util.List;

import com.dairy.dto.advanceToFarmer.AdvanceToFarmerRequestDto;
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;
import com.dairy.entity.FeedToFarmer;

public interface AdvanceToFarmerService {

	boolean addAdvance(AdvanceToFarmerRequestDto advanceRequestDto);
	
	List<AdvanceToFarmerResponseDto> getAllAdvanceToFarmer();

	AdvanceToFarmerResponseDto findById(long id);

	boolean updateAdvance(AdvanceToFarmerRequestDto advanceRequestDto);

	Double findTotalOfRemainingAmountByFarmerIdAndBranchId(Long farmerId, int branchId);

	AdvanceToFarmer getAdvanceToFarmerByFarmerId(Long farmerId);



	

}
