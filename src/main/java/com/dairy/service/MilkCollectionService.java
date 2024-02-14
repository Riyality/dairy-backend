package com.dairy.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;

public interface MilkCollectionService {

	List<MilkCollectionResponseDto> getAllMilkCollectionData();

	boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto,int branchId);

	List<MilkCollectionResponseDto> findByFromDateAndToDateAndAnimalType(Date fromDate, Date toDate,
			String animalType);
	List<MilkCollectionResponseDto> findAllByBranchIdAndDateOfCollection(int branchId, LocalDate dateOfCollection);

	List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(LocalDate fromDate, LocalDate toDate, String animalType);

	//List<MilkCollectionResponseDto> getRecordsByFarmerId(Long farmerId);

	List<MilkCollectionResponseDto> getAllMilkCollectionDataByFarmerId(int farmerId);

	List<MilkCollectionResponseDto> getRecordsByFarmerIdFromDateAndToDateAndAnimalType(Long farmerId,
			LocalDate fromDate, LocalDate toDate, String animalType);


}
