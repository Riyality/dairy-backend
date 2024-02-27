package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.advanceToFarmer.AdvanceToFarmerRequestDto;
import com.dairy.dto.advanceToFarmer.AdvanceToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedToFarmer;
import com.dairy.mapper.advanceToFarmer.AdvanceToFarmerMapper;
import com.dairy.repository.AdvanceToFarmerRepository;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.service.AdvanceToFarmerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdvanceToFarmerServiceImpl implements AdvanceToFarmerService {
	@Autowired
	AdvanceToFarmerRepository advanceToFarmerRepository;

	@Autowired
	AdvanceToFarmerMapper advanceToFarmerMapper;

	@Autowired
	FarmerRepository farmerRepository;

	@Autowired
	BranchRepository branchRepository;

	@Override
	public boolean addAdvance(AdvanceToFarmerRequestDto advanceRequestDto) {
	    try {
	        // Check if an advance record already exists for the given farmer
	        Optional<AdvanceToFarmer> existingAdvanceOpt = advanceToFarmerRepository.findByFarmerId(advanceRequestDto.getFarmerId());

	        if (existingAdvanceOpt.isPresent()) {
	            // Update existing advance record
	            AdvanceToFarmer existingAdvance = existingAdvanceOpt.get();
	            float newAmount = existingAdvance.getRemainingAmount() + advanceRequestDto.getAmount();
	            existingAdvance.setRemainingAmount(newAmount);
	            existingAdvance.setAmount(newAmount);
	            advanceToFarmerRepository.save(existingAdvance);
	        } else {
	            // Create a new advance record
	            AdvanceToFarmer newAdvance = advanceToFarmerMapper.toEntity(advanceRequestDto);
	            newAdvance.setRemainingAmount(advanceRequestDto.getAmount());

	            Optional<Branch> branchOpt = branchRepository.findById(advanceRequestDto.getBranchId());
	            branchOpt.ifPresent(newAdvance::setBranch);

	            Optional<Farmer> farmerOpt = farmerRepository.findById(advanceRequestDto.getFarmerId());
	            farmerOpt.ifPresent(newAdvance::setFarmer);

	            advanceToFarmerRepository.save(newAdvance);
	        }

	        return true;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        return false;
	    }
	}


	@Override
	public List<AdvanceToFarmerResponseDto> getAllAdvanceToFarmer() {
		List<AdvanceToFarmer> advanceToFarmer = advanceToFarmerRepository.findAll();
		return advanceToFarmerMapper.toList(advanceToFarmer);
	}

	@Override
	public AdvanceToFarmerResponseDto findById(long id) {
		Optional<AdvanceToFarmer> opt = advanceToFarmerRepository.findById(id);
		if (opt.isPresent())
			return advanceToFarmerMapper.toAdvanceToFarmerResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean updateAdvance(AdvanceToFarmerRequestDto advanceRequestDto) {
		try {
			AdvanceToFarmer advancetoFarmer = advanceToFarmerMapper.toEntity(advanceRequestDto);
			Optional<Branch> branchOpt = branchRepository.findById(advanceRequestDto.getBranchId());
			if (branchOpt.isPresent())
				advancetoFarmer.setBranch(branchOpt.get());

			Optional<Farmer> farmerOpt = farmerRepository.findById(advanceRequestDto.getFarmerId());
			if (farmerOpt.isPresent())
				advancetoFarmer.setFarmer(farmerOpt.get());

			advanceToFarmerRepository.save(advancetoFarmer);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public Double findTotalOfRemainingAmountByFarmerIdAndBranchId(Long farmerId, int branchId) {
		
		return advanceToFarmerRepository.findTotalOfRemainingAmountByFarmerIdAndBranchId(farmerId,branchId);
	}


	@Override
	public AdvanceToFarmer getAdvanceToFarmerByFarmerId(Long farmerId) {
		
		
		  // Use your repository to find the record by farmerId
        Optional<AdvanceToFarmer> advanceToFarmerOptional = advanceToFarmerRepository.findByFarmerId(farmerId);

        // Check if the record exists and return it, otherwise return null
        return advanceToFarmerOptional.orElse(null);
	}


	

}
