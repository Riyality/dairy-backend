package com.dairy.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.AdvanceToFarmer;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedType;
import com.dairy.entity.MilkCollection;
import com.dairy.mapper.branch.BranchMapper;
import com.dairy.mapper.milkCollection.MilkCollectionMapper;
import com.dairy.repository.BranchRepository;
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
		List<MilkCollection> list = milkCollectionRepository.findByDateAndType(fromDate, toDate, animalType);
		return milkCollectionMapper.toList(list);
	}

	@Override
	public List<Object[]> findByDateAndTypeAndSumTotalAmountByFarmer(Date fromDate, Date toDate, String animalType) {
		return milkCollectionRepository.findByDateAndTypeAndSumTotalAmountAndQuantityByFarmer(fromDate, toDate,
				animalType);
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

}
