package com.dairy.mapper.bonusToFarmer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.entity.BonusToFarmer;
import com.dairy.entity.Farmer;

@Component
public class BonusToFarmerMapper {
	public BonusToFarmer toEntity(BonusToFarmerRequestDto bonusToFarmerRequestDto) {
		if (bonusToFarmerRequestDto == null) {
			return null;
		}

		BonusToFarmer bonusToFarmer = new BonusToFarmer();
		bonusToFarmer.setId(bonusToFarmerRequestDto.getId());
		bonusToFarmer.setFromDate(bonusToFarmerRequestDto.getFromDate());
		bonusToFarmer.setToDate(bonusToFarmerRequestDto.getToDate());
		bonusToFarmer.setBonusAmountPerLiter(bonusToFarmerRequestDto.getBonusAmountPerLiter());
		bonusToFarmer.setTotalQuantity(bonusToFarmerRequestDto.getTotalQuantity());
		bonusToFarmer.setTotalBonusAmount(bonusToFarmerRequestDto.getTotalBonusAmount());
		bonusToFarmer.setMilkType(bonusToFarmerRequestDto.getMilkType());

		return bonusToFarmer;
	}
	
	public BonusToFarmerResponseDto toResponseDto( BonusToFarmer bonusToFarmer ) {
		BonusToFarmerResponseDto responseDto = new BonusToFarmerResponseDto();
		responseDto.setId(bonusToFarmer.getId());
		responseDto.setFromDate(bonusToFarmer.getFromDate());
		responseDto.setToDate(bonusToFarmer.getToDate());
		responseDto.setTotalQuantity(bonusToFarmer.getTotalQuantity());
		responseDto.setBonusAmountPerLiter(bonusToFarmer.getBonusAmountPerLiter());
		responseDto.setTotalBonusAmount(bonusToFarmer.getTotalBonusAmount());
		responseDto.setMilkType(bonusToFarmer.getMilkType());
		if (bonusToFarmer.getBranch() != null) {
			responseDto.setBranchId(bonusToFarmer.getBranch().getId());
			responseDto.setBranchName(bonusToFarmer.getBranch().getName());
		}

		if (bonusToFarmer.getFarmer() != null) {
			responseDto.setFarmerId(bonusToFarmer.getFarmer().getId());
			responseDto.setFarmerName(bonusToFarmer.getFarmer().getName());

		}
		
		return responseDto;
	}

	public List<BonusToFarmerResponseDto> toList( List<BonusToFarmer> bonusTofasrmerList ) {
		return bonusTofasrmerList.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}


}
