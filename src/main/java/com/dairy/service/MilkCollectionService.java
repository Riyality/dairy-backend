package com.dairy.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;

public interface MilkCollectionService {

	List<MilkCollectionResponseDto> getAllMilkCollectionData();

	boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto);

	List<MilkCollectionResponseDto> findByFromDateAndToDateAndAnimalType(Date fromDate, Date toDate,
			String animalType);

	List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(Date fromDate, Date toDate, String animalType);

	List<MilkCollectionResponseDto> getAllMilkCollectionDataByFarmerId(int farmerId);

	
	

	
	
}
