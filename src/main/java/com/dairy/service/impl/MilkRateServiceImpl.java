package com.dairy.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.milkRate.MilkRateRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.MilkRate;
import com.dairy.mapper.milkRate.MilkRateMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.MilkRateRepository;
import com.dairy.service.MilkRateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MilkRateServiceImpl implements MilkRateService{

	
	@Autowired
	private MilkRateMapper milkRateMapper;
	
	@Autowired
	private MilkRateRepository milkRateRepository;

	@Autowired
	private BranchRepository branchRepository;

	
	@Override
	public Float getMilkRateByTypeAndFatAndSNFAndBranch(String type, float fat, float snf, int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if (branchOptional.isPresent()) {
			MilkRate milkRate = milkRateRepository.findByTypeAndFatAndSnfAndBranch(type,fat,snf, branchOptional.get());
			
			if (milkRate != null) {
			    
				return milkRate.getRate();
			} else {
			   
				System.out.println("Milk Rates Null");
				return null;
			}

		}
		return null;
	}



	@Override
	public boolean saveMilkRate(MilkRateRequestDto milkRateDto) {
		System.out.println("MILK RATES:"+milkRateDto);
		MilkRate milkRate = milkRateMapper.toEntity(milkRateDto);
		Optional<Branch> opt = branchRepository.findById(milkRateDto.getBranchId());
		if (opt.isPresent()) {
			milkRate.setBranch(opt.get());
			
        milkRateRepository.save(milkRate);
		return true;
		}
		return false;
	}




	
}
