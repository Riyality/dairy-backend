package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;
import com.dairy.entity.BonusToFarmer;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.mapper.bonusToFarmer.BonusToFarmerMapper;
import com.dairy.repository.BonusToFarmerRepository;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.service.BonusToFarmerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BonusToFarmerServiceImpl implements BonusToFarmerService {
	@Autowired
	private BonusToFarmerRepository bonusToFarmerRepository;

	@Autowired
	private BonusToFarmerMapper bonusToFarmerMapper;
	@Autowired
	private FarmerRepository farmerRepository;
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public boolean addBonus(BonusToFarmerRequestDto bonusToFarmerRequestDto) {
		try {
			BonusToFarmer bonusToFarmer = bonusToFarmerMapper.toEntity(bonusToFarmerRequestDto);
			
			Optional<Farmer> farmerOpt = farmerRepository.findById(bonusToFarmerRequestDto.getFarmerId());
			Optional<Branch> opt = branchRepository.findById(bonusToFarmerRequestDto.getBranchId());
			
			if ( farmerOpt.isPresent() && opt.isPresent()) {
				bonusToFarmer.setBranch(opt.get());
				bonusToFarmer.setFarmer(farmerOpt.get());
			}

			bonusToFarmerRepository.save(bonusToFarmer);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<BonusToFarmerResponseDto> findAllBonusStatus(int id) {
		Optional<Branch> branchOptional = branchRepository.findById(id);
		if (branchOptional.isPresent()) {
			List<BonusToFarmer> list = bonusToFarmerRepository.findAllBonusRecord( branchOptional.get());
			return bonusToFarmerMapper.toList(list);
		}
		return null;
	}
}
