package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.supplier.SupplierRequestDto;
import com.dairy.dto.supplier.SupplierResponseDto;
import com.dairy.entity.Bank;
import com.dairy.service.BankService;
import com.dairy.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	@Autowired
	SupplierService supplierService;

	@Autowired
	BankService bankService;

	@PostMapping
	public ResponseEntity<String> addSupplier(@RequestBody SupplierRequestDto supplierRequestDto) {
		Bank bank = bankService.addBank(supplierRequestDto.getBankRequestDto());

		boolean addSupp = supplierService.addSupplier(supplierRequestDto, bank);
		if (addSupp)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_SUPPLIER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_SUPPLIER_ERROR_MSG);
	}

	@GetMapping
	public ResponseEntity<List<SupplierResponseDto>> allSupplier() {
		return new ResponseEntity<>(supplierService.getAllSupplier(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<SupplierResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.findById(id));
	}

	@PutMapping
	public ResponseEntity<String> updateSupplier(@RequestBody SupplierRequestDto supplierRequestDto) {
		Bank bank = bankService.updateBank(supplierRequestDto.getBankRequestDto());

		boolean isUpdate = supplierService.updateSupplier(supplierRequestDto, bank);
		if (isUpdate)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.UPDATE_SUPPLIER_SUCCESS_MESSAGE);

		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.UPDATE_SUPPLIER_ERROR_MSG);

	}
}
