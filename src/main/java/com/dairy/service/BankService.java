package com.dairy.service;

import java.util.List;

import com.dairy.dto.bankdetails.BankRequestDto;
import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.entity.Bank;

public interface BankService {

	List<BankResponseDto> getAllBankDetails();

	Bank addBank(BankRequestDto bankRequestDto);

	Bank updateBank(BankRequestDto bankRequestDto);



}
