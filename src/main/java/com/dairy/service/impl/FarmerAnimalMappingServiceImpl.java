package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingRequestDto;
import com.dairy.dto.FarmerAnimalMapping.FarmerAnimalMappingResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FarmerAnimalMapping;
import com.dairy.mapper.farmerAnimalMapping.FarmerAnimalMappingMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerAnimalMappingRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.service.FarmerAnimalMappingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FarmerAnimalMappingServiceImpl implements FarmerAnimalMappingService {

	@Autowired
	private FarmerAnimalMappingMapper farmerAnimalMappingMapper;

	@Autowired
	private FarmerAnimalMappingRepository farmerAnimalMappingRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public List<FarmerAnimalMappingResponseDto> getAllAnimal() {
		List<FarmerAnimalMapping> farmerAnimalMapping = farmerAnimalMappingRepository.findAll();
		return farmerAnimalMappingMapper.toList(farmerAnimalMapping);

	}

	@Override
	public boolean createAnimal(FarmerAnimalMappingRequestDto reqDto) {
		try {
			FarmerAnimalMapping farmerAnimalMapping = farmerAnimalMappingMapper.toEntity(reqDto);
			Optional<Branch> opt = branchRepository.findById(reqDto.getBranchId());
			Optional<Farmer> farmerOpt = farmerRepository.findById(reqDto.getFarmerId());
			if (opt.isPresent() && farmerOpt.isPresent()) {
				farmerAnimalMapping.setBranch(opt.get());
				farmerAnimalMapping.setFarmer(farmerOpt.get());
			}

			farmerAnimalMappingRepository.save(farmerAnimalMapping);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public FarmerAnimalMappingResponseDto findById(long id) {
		Optional<FarmerAnimalMapping> opt = farmerAnimalMappingRepository.findById(id);
		if (opt.isPresent())
			return farmerAnimalMappingMapper.toFarmerAnimalMappingResponseDto(opt.get());

		return null;
	}

	@Override
	public boolean updateAnimal(FarmerAnimalMappingRequestDto dto) {
		try {
			FarmerAnimalMapping farmerAnimalMapping = farmerAnimalMappingMapper.toEntity(dto);
			Optional<Branch> opt = branchRepository.findById(dto.getBranchId());
			Optional<Farmer> farmerOpt = farmerRepository.findById(dto.getFarmerId());
			if (opt.isPresent() && farmerOpt.isPresent()) {
				farmerAnimalMapping.setBranch(opt.get());
				farmerAnimalMapping.setFarmer(farmerOpt.get());
			}
			farmerAnimalMappingRepository.save(farmerAnimalMapping);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
