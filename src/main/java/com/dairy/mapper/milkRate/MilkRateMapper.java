package com.dairy.mapper.milkRate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dairy.dto.milkRate.MilkRateResponseDto;
import com.dairy.entity.MilkRate;

@Component
public class MilkRateMapper {


	public MilkRateResponseDto toResponseDto( MilkRate milkRate ) {
		MilkRateResponseDto responseDto = new MilkRateResponseDto();
		responseDto.setAnimalType(milkRate.getType());
		responseDto.setMilkFat(milkRate.getFat());
		responseDto.setMilkSNF(milkRate.getSnf());
		responseDto.setMilkRate(milkRate.getRate());

		return responseDto;
	}

	public List<MilkRateResponseDto> toList( List<MilkRate> milkRateList ) {
		return milkRateList.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}
	
}
