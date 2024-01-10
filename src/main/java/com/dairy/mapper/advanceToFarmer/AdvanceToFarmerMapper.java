package com.dairy.mapper.advanceToFarmer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.advanceToFarmer.AdvanceToFarmerRequestDto;
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;

@Component
public class AdvanceToFarmerMapper {
	public AdvanceToFarmer toEntity(AdvanceToFarmerRequestDto requestdto) {

		if (requestdto == null) {
			return null;
		}
		AdvanceToFarmer advanceToFarmer = new AdvanceToFarmer();

		advanceToFarmer.setId(requestdto.getId());
		advanceToFarmer.setDateOfAdvance(requestdto.getDateOfAdvance());
		advanceToFarmer.setAmount(requestdto.getAmount());
		advanceToFarmer.setDeduction(requestdto.getDeduction());
		advanceToFarmer.setRemainingAmount(requestdto.getRemainingAmount());
		return advanceToFarmer;

	}

	public AdvanceToFarmerResponseDto toAdvanceToFarmerResponseDto(AdvanceToFarmer advanceToFarmer) {
		if (advanceToFarmer == null) {
			return null;
		}
		
		AdvanceToFarmerResponseDto responseDto=new AdvanceToFarmerResponseDto();
		responseDto.setId(advanceToFarmer.getId());
		responseDto.setDateOfAdvance(advanceToFarmer.getDateOfAdvance());
		responseDto.setAmount(advanceToFarmer.getAmount());
		responseDto.setDeduction(advanceToFarmer.getAmount());
		responseDto.setRemainingAmount(advanceToFarmer.getRemainingAmount());
		
		if (advanceToFarmer.getFarmer() != null) {
			responseDto.setFarmerId(advanceToFarmer.getFarmer().getId());
			responseDto.setFarmerName(advanceToFarmer.getFarmer().getName());
		}
		return responseDto;
	}
	
	public List<AdvanceToFarmerResponseDto> toList( List<AdvanceToFarmer> list ) {
		List<AdvanceToFarmerResponseDto> dtos = new ArrayList<>();
		for ( AdvanceToFarmer entity : list ) {
			dtos.add( toAdvanceToFarmerResponseDto( entity ) );
		}
		return dtos;
	}

}
