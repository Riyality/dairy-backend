package com.dairy.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;

public interface MilkCollectionService {

	List<MilkCollectionResponseDto> getAllMilkCollectionData();

	boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto,int branchId);

	List<MilkCollectionResponseDto> findByFromDateAndToDateAndAnimalType(Date fromDate, Date toDate,
			String animalType);
	List<MilkCollectionResponseDto> findAllByBranchIdAndDateOfCollection(int branchId, LocalDate dateOfCollection);

	List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(LocalDate fromDate, LocalDate toDate, String animalType, String flag);

	List<MilkCollectionResponseDto> getAllMilkCollectionDataByFarmerId(int farmerId);

	List<MilkCollectionResponseDto> getRecordsByFarmerIdFromDateAndToDateAndAnimalType(Long farmerId,
			LocalDate fromDate, LocalDate toDate, String animalType);
	

	Float findSumOfMilkCollectionByTypeAndShiftForToday(String animalType, String shift, int branchId);


	boolean updatePaymentStatusbyFarmerIdBranchIdAndMilktype(MilkCollectionRequestDto dto);

	List<MilkCollectionResponseDto> getMilkCollectionDataByFromDateTodateMilktypeShiftAndBranchId(LocalDate fromDate, LocalDate toDate,
			String milkType, String shift, int branchId, String flagValue);

	List<MilkCollectionResponseDto> getMilkCollectionDataBydateMilktypeShiftAndBranchId(LocalDate date, String milkType,
			String shift, int branchId);

	


}
