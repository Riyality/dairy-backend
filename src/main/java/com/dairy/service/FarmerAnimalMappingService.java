package com.dairy.service;

import java.util.List;

import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingRequestDto;
import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingResponseDto;

public interface FarmerAnimalMappingService {

	List<FarmerAnimalMappingResponseDto> getAllAnimal(int branchId);

	boolean createAnimal(FarmerAnimalMappingRequestDto reqDto);

	FarmerAnimalMappingResponseDto findById(long id);

	boolean updateAnimal(FarmerAnimalMappingRequestDto dto);

}
