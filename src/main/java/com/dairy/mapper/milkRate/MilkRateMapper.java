package com.dairy.mapper.milkRate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dairy.dto.milkRate.MilkRateRequestDto;
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
	public MilkRate toEntity(MilkRateRequestDto milkRateDto) {
		MilkRate milkRate = new MilkRate();
		milkRate.setId(milkRateDto.getId());
		milkRate.setDate_of_rate(milkRateDto.getDate_of_rate());
		milkRate.setType(milkRateDto.getAnimalType());
		milkRate.setFat(milkRateDto.getMilkFat());
		milkRate.setSnf(milkRateDto.getMilkSNF());
		milkRate.setRate(milkRateDto.getMilkRate());
		milkRate.setRemark(milkRateDto.getRemark());
		return milkRate;
	}
	
}
