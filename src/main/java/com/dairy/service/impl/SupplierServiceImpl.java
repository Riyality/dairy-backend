package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.supplier.SupplierRequestDto;
import com.dairy.dto.supplier.SupplierResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Supplier;
import com.dairy.mapper.supplier.SupplierMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.SupplierRepository;
import com.dairy.service.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	SupplierMapper supplierMapper;

	@Autowired
	BranchRepository branchRepository;

	@Override
	public boolean addSupplier(SupplierRequestDto supplierRequestDto, Bank bank) {

		try {

			Supplier supplier = supplierMapper.toEntity(supplierRequestDto);
			supplier.setBank(bank);
			Optional<Branch> branchOpt = branchRepository.findById(supplierRequestDto.getBranchId());
			if (branchOpt.isPresent())
				supplier.setBranch(branchOpt.get());
			supplierRepository.save(supplier);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return false;

	}

	@Override
	public List<SupplierResponseDto> getAllSupplier(int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
			List<Supplier> supplier = supplierRepository.findByBranch( branchOptional.get() );
			return supplierMapper.toList(supplier);
		}
		return null;
	}

	@Override
	public SupplierResponseDto findById(Long id ,int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		
		if (branchOptional.isPresent()) {
			Optional<Supplier> opt = supplierRepository.findByIdAndBranch(id ,branchOptional.get());
			return supplierMapper.toSupplierResponseDto(opt.get());
		}			
		return null;
	}

	@Override
	public boolean updateSupplier(SupplierRequestDto supplierRequestDto, Bank bank) {
		try {
			Supplier supplier = supplierMapper.toEntity(supplierRequestDto);
			supplier.setBank(bank);
			
			Optional<Branch> branchOpt = branchRepository.findById(supplierRequestDto.getBranchId());
			if (branchOpt.isPresent())
				supplier.setBranch(branchOpt.get());

			supplierRepository.save(supplier);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return false;
	}

}
