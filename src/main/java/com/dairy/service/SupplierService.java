package com.dairy.service;

import java.util.List;

import com.dairy.dto.supplier.SupplierRequestDto;
import com.dairy.dto.supplier.SupplierResponseDto;
import com.dairy.entity.Bank;

public interface SupplierService {

	boolean addSupplier(SupplierRequestDto supplierRequestDto, Bank bank);

	List<SupplierResponseDto> getAllSupplier(int branchId);

	SupplierResponseDto findById(Long id ,int branchId);

	boolean updateSupplier(SupplierRequestDto supplierRequestDto, Bank bank);

}
