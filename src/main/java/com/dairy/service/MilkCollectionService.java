package com.dairy.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalDate;
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

	List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(Date fromDate, Date toDate, String animalType);

	List<MilkCollectionResponseDto> getAllMilkCollectionDataByFarmerId(int farmerId);

	List<MilkCollectionResponseDto> findAllByBranchIdAndDateOfCollection(int branchId, LocalDate dateOfCollection);

}
