
package com.dairy.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.MilkCollection;
import com.dairy.mapper.milkCollection.MilkCollectionMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.repository.MilkCollectionRepository;
import com.dairy.service.MilkCollectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MilkCollectionServiceImpl implements MilkCollectionService {

	@Autowired
	private MilkCollectionMapper milkCollectionMapper;

	@Autowired
	private MilkCollectionRepository milkCollectionRepository;

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;


	@Override
	public List<MilkCollectionResponseDto> getAllMilkCollectionData() {
		return null;
	}

	@Override
	public boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto, int branchId) {
		try {

			MilkCollection milkCollection = milkCollectionMapper.toEntity(milkCollectionRequestDto);
			
			Optional<Branch> opt = branchRepository.findById(milkCollectionRequestDto.getBranchId());
			if (opt.isPresent())
				milkCollection.setBranch(opt.get());
						Optional<Farmer> farmer = farmerRepository.findById( milkCollectionRequestDto.getFarmerId());
			if (farmer.isPresent())
				milkCollection.setFarmer(farmer.get());
			
			MilkCollection addedMilkCollection = milkCollectionRepository.save(milkCollection);

			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<MilkCollectionResponseDto> findByFromDateAndToDateAndAnimalType(Date fromDate, Date toDate,
			String animalType) {
		List<MilkCollection> list=milkCollectionRepository.findByDateAndType(
	            fromDate, toDate, animalType);
		return milkCollectionMapper.toDateAndTypewiseList(list);
	}

	@Override
	public List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(LocalDate fromDate, LocalDate toDate, String animalType,String Flag) {
		if ("Payment".equals(Flag)) {
	        return milkCollectionRepository.findByDateAndTypeAndSumTotalAmountAndQuantityByFarmerForPayment(fromDate, toDate, animalType);
	    } else {
	      
	        return milkCollectionRepository.findByDateAndTypeAndSumTotalAmountAndQuantityByFarmerForBonus(fromDate, toDate, animalType);
	    }
	}

	@Override
	public List<MilkCollectionResponseDto> getAllMilkCollectionDataByFarmerId(int farmerId) {
		return milkCollectionRepository.findByFarmer(farmerId);
	}

	@Override
	public List<MilkCollectionResponseDto> findAllByBranchIdAndDateOfCollection(int branchId,
			LocalDate dateOfCollection) {

		List<MilkCollection> milkCollection = null;
		Optional<Branch> branchOptional = branchRepository.findById(branchId);

		if (branchOptional.isPresent()) {
			milkCollection = milkCollectionRepository.findByBranchAndDateOfCollection(branchOptional.get(),
					dateOfCollection);
		}

		return milkCollectionMapper.toList(milkCollection);
	}
	@Override
	public List<MilkCollectionResponseDto> getRecordsByFarmerIdFromDateAndToDateAndAnimalType(Long farmerId,
			LocalDate fromDate, LocalDate toDate, String animalType) {		
		 List<MilkCollection> milkCollection = milkCollectionRepository.findByFarmerDateOfCollectionAndType(farmerId,fromDate,toDate,animalType);
		
		return milkCollectionMapper.toList(milkCollection);
	}

	@Override
	public boolean updatePaymentStatusbyFarmerIdBranchIdAndMilktype(MilkCollectionRequestDto dto) {
	    // Convert farmerId and branchId to Farmer and Branch entities
	    Farmer farmer = farmerRepository.findById((long) dto.getFarmerId()).orElse(null);
	    Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);

	    if (farmer != null && branch != null) {
	        // Fetch records with matching criteria
	        List<MilkCollection> matchingRecords = milkCollectionRepository.findByFarmerAndBranchAndType(farmer, branch, dto.getAnimalType());

	        if (!matchingRecords.isEmpty()) {
	            // Update payment status for matching records
	            for (MilkCollection record : matchingRecords) {
	                record.setPayment_status("Paid");
	            }

	            // Save the updated entities back to the repository
	            milkCollectionRepository.saveAll(matchingRecords);

	            return true;  // Update successful
	        } else {
	            return false; // No matching records found
	        }
	    } else {
	        return false; // Farmer or Branch not found, update failed
	    }
	}

@Override
	public Float findSumOfMilkCollectionByTypeAndShiftForToday(String animalType, String shift,int branchId) {
        LocalDate today = LocalDate.now();
        return milkCollectionRepository.findSumOfMilkCollectionByTypeAndShiftForToday(today, animalType, shift,branchId);
    }



	

}

