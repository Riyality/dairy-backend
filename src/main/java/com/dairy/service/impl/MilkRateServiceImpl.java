package com.dairy.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			return milkRate.getRate();
		}
		return null;
	}
	
}