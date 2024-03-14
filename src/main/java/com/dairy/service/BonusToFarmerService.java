package com.dairy.service;

import java.time.LocalDate;
import java.util.List;

import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;

public interface BonusToFarmerService {

	boolean addBonus(BonusToFarmerRequestDto bonusToFarmerRequestDto);

	List<BonusToFarmerResponseDto> findAllBonusStatus(int id);

	List<BonusToFarmerResponseDto> getBonusRecordsDatewise(LocalDate fromDate, LocalDate toDate, int branchId, String flag);

}
