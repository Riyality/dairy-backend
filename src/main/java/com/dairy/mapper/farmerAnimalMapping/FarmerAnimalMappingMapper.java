package com.dairy.mapper.farmerAnimalMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingRequestDto;
import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingResponseDto;
import com.dairy.entity.FarmerAnimalMapping;

@Component
public class FarmerAnimalMappingMapper {

	public FarmerAnimalMapping toEntity(FarmerAnimalMappingRequestDto requestDto) {
		if (requestDto == null) {
			return null;
		}
		FarmerAnimalMapping farmerAnimalMapping = new FarmerAnimalMapping();
		farmerAnimalMapping.setId(requestDto.getId());
		farmerAnimalMapping.setCount(requestDto.getCount());
		farmerAnimalMapping.setStatus(requestDto.getStatus());
		farmerAnimalMapping.setType(requestDto.getType());
		farmerAnimalMapping.setRemark(requestDto.getRemark());

		return farmerAnimalMapping;

	}

	public FarmerAnimalMappingResponseDto toFarmerAnimalMappingResponseDto(FarmerAnimalMapping farmerAnimalMapping) {
		if (farmerAnimalMapping == null) {
			return null;
		}
		FarmerAnimalMappingResponseDto responseDto = new FarmerAnimalMappingResponseDto();
		responseDto.setId(farmerAnimalMapping.getId());
		responseDto.setCount(farmerAnimalMapping.getCount());
		responseDto.setStatus(farmerAnimalMapping.getStatus());
		responseDto.setType(farmerAnimalMapping.getType());
		responseDto.setRemark(farmerAnimalMapping.getRemark());

		if (farmerAnimalMapping.getBranch() != null) {
			responseDto.setBranchId(farmerAnimalMapping.getBranch().getId());
		}

		if (farmerAnimalMapping.getFarmer() != null) {
			responseDto.setFarmerId(farmerAnimalMapping.getFarmer().getId());
			responseDto.setFarmerName(farmerAnimalMapping.getFarmer().getName());

		}
		return responseDto;

	}

	public List<FarmerAnimalMappingResponseDto> toList(List<FarmerAnimalMapping> list) {
		List<FarmerAnimalMappingResponseDto> dtos = new ArrayList<>();
		for (FarmerAnimalMapping entity : list) {
			dtos.add(toFarmerAnimalMappingResponseDto(entity));
		}
		return dtos;
	}

}
