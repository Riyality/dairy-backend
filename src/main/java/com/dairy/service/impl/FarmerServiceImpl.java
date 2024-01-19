package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.Route;
import com.dairy.mapper.bank.BankMapper;
import com.dairy.mapper.farmers.FarmerMapper;
import com.dairy.repository.BankRepository;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.repository.RouteRepository;
import com.dairy.service.FarmerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private FarmerMapper farmerMapper;

	@Autowired
	private BankMapper bankMapper;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private RouteRepository routeRepository;

	@Override
	public boolean add(FarmerRequestDto dto) {
		try {
			Bank bank = bankMapper.toEntity(dto.getBankRequestDto());
			Bank addedBank = bankRepository.save(bank);

			int routeId = dto.getRoute();

			Farmer farmer = farmerMapper.toEntity(dto);
			farmer.setBank(addedBank);
			Optional<Branch> branchOpt = branchRepository.findById(dto.getBranchId());
			Optional<Route> routeOpt = routeRepository.findById(routeId);
			if (branchOpt.isPresent() && routeOpt.isPresent()) {
				farmer.setBranch(branchOpt.get());
				farmer.setRoute(routeOpt.get());
			}
			farmerRepository.save(farmer);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public FarmerResponseDto findById(Long id) {
		Optional<Farmer> farmerOpt = farmerRepository.findById(id);
		if (farmerOpt.isPresent()) {
			FarmerResponseDto dto = farmerMapper.toResponseDto(farmerOpt.get());
			BankResponseDto bankResponse = bankMapper.toBankResponseDto(farmerOpt.get().getBank());
			dto.setBank(bankResponse);
			return dto;
		}
		return null;
	}

	@Override
	public List<FarmerResponseDto> findAllActive(int id) {
		Optional<Branch> branchOptional = branchRepository.findById(id);
		if (branchOptional.isPresent()) {
			List<Farmer> list = farmerRepository.findAllByStatusAndBranch("Active", branchOptional.get());
			return farmerMapper.toList(list);
		}
		return null;
	}

	@Override
	public List<FarmerResponseDto> farmersListByRoute(int branchId, int routeId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		Optional<Route> routeOptional = routeRepository.findById(routeId);
		if (branchOptional.isPresent() && routeOptional.isPresent()) {
			// here route is string route cha column foreign key pahije just
			// like branch+
			List<Farmer> list = farmerRepository.findAllByRouteAndBranch(routeOptional.get(), branchOptional.get());
			return farmerMapper.toList(list);
		}
		return null;
	}

	@Override
	public boolean update(FarmerRequestDto dto) {
		try {
			Bank bank = bankMapper.toEntity(dto.getBankRequestDto());
			Bank addedBank = bankRepository.save(bank);

			int routeId = dto.getRoute();

			Farmer farmer = farmerMapper.toEntity(dto);
			farmer.setBank(addedBank);
			Optional<Branch> branchOpt = branchRepository.findById(dto.getBranchId());
			Optional<Route> routeOpt = routeRepository.findById(routeId);
			if (branchOpt.isPresent() && routeOpt.isPresent()) {
				farmer.setBranch(branchOpt.get());
				farmer.setRoute(routeOpt.get());
			}
			farmerRepository.save(farmer);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
}
