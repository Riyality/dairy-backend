package com.dairy.service;

import java.time.LocalDate;
import java.util.List;

import com.dairy.dto.advanceToFarmer.AdvanceToFarmerRequestDto;
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;

public interface AdvanceToFarmerService {

	boolean addAdvance(AdvanceToFarmerRequestDto advanceRequestDto);
	
	List<AdvanceToFarmerResponseDto> getAllAdvanceToFarmer(int branchId);

	AdvanceToFarmerResponseDto findById(long id, int branchId);

	boolean updateAdvance(AdvanceToFarmerRequestDto advanceRequestDto);

	Double findTotalOfRemainingAmountByFarmerIdAndBranchId(Long farmerId, int branchId);

	AdvanceToFarmer getAdvanceToFarmerByFarmerId(Long farmerId);

	List<AdvanceToFarmerResponseDto> getAdvanceRecordsDatewise(LocalDate fromDate, LocalDate toDate, int branchId, String flag);



	

}
