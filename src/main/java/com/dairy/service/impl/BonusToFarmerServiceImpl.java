package com.dairy.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.bonusToFarmer.BonusToFarmerRequestDto;
import com.dairy.dto.bonusToFarmer.BonusToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;
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

	@Override
	public List<BonusToFarmerResponseDto> getBonusRecordsDatewise(LocalDate fromDate, LocalDate toDate, int branchId,
			String flag) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
			if (isNumeric(flag)) {
				 long farmerId = Long.parseLong(flag);
			        Optional<Farmer> farmer = farmerRepository.findById(farmerId);
			        List<BonusToFarmer> advanceToFarmer = bonusToFarmerRepository.findByBonusDateBetweenAndBranchAndFarmer(fromDate,toDate, branchOptional.get(),farmer );
					return bonusToFarmerMapper.toList(advanceToFarmer); 
			 }
			List<BonusToFarmer> bonusToFarmer = bonusToFarmerRepository.findByBonusDateBetweenAndBranch(fromDate,toDate, branchOptional.get() );
			return bonusToFarmerMapper.toList(bonusToFarmer);
		}
		return null;	}
	
	private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
