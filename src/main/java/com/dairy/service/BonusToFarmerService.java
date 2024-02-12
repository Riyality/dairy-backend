package com.dairy.service;

import java.util.List;

import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;

public interface BonusToFarmerService {

	boolean addBonus(BonusToFarmerRequestDto bonusToFarmerRequestDto);

	List<BonusToFarmerResponseDto> findAllBonusStatus(int id);

}
