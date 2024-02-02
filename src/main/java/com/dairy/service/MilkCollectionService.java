package com.dairy.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;

public interface MilkCollectionService {

	List<MilkCollectionResponseDto> getAllMilkCollectionData();

	boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto);

	List<MilkCollectionResponseDto> findByFromDateAndToDateAndAnimalType(Date fromDate, Date toDate,
			String animalType);
	List<MilkCollectionResponseDto> findAllByBranchIdAndDateOfCollection(int branchId, LocalDate dateOfCollection);

	List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(LocalDate fromDate, LocalDate toDate, String animalType);

	List<MilkCollectionResponseDto> getRecordsByFarmerId(Long farmerId);


}
