package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.supplier.SupplierRequestDto;
import com.dairy.dto.supplier.SupplierResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Supplier;
import com.dairy.mapper.supplier.SupplierMapper;
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

	@Override
	public boolean addSupplier(SupplierRequestDto supplierRequestDto, Bank bank) {

		try {

			Supplier supplier = supplierMapper.toEntity(supplierRequestDto);
			supplier.setBank(bank);

			supplierRepository.save(supplier);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return false;

	}

	@Override
	public List<SupplierResponseDto> getAllSupplier() {
		List<Supplier> supplier = supplierRepository.findAll();
		return supplierMapper.toList(supplier);

	}

	@Override
	public SupplierResponseDto findById(Long id) {
		Optional<Supplier> opt = supplierRepository.findById(id);
		if (opt.isPresent())
			return supplierMapper.toSupplierResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean updateSupplier(SupplierRequestDto supplierRequestDto, Bank bank) {
		try {
			Supplier supplier = supplierMapper.toEntity(supplierRequestDto);
			supplier.setBank(bank);

			supplierRepository.save(supplier);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return false;
	}

}
