package com.dairy.mapper.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.bankdetails.BankRequestDto;
import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.entity.Bank;

@Component
public class BankMapper {
	public Bank toEntity(BankRequestDto bankRequestDto) {
		if (bankRequestDto == null) {
			return null;
		}

		Bank bank = new Bank();
		bank.setId(bankRequestDto.getId());
		bank.setBankName(bankRequestDto.getBankName());
		bank.setIfscCode(bankRequestDto.getIfscCode());
		bank.setBranchName(bankRequestDto.getBranchName());
		bank.setAccountNumber(bankRequestDto.getAccountNumber());
		bank.setUpiId(bankRequestDto.getUpiId());
		return bank;
	}

	public BankResponseDto toBankResponseDto(Bank bank) {
		if (bank == null) {
			return null;
		}

		BankResponseDto responseDto = new BankResponseDto();
		responseDto.setId(bank.getId());
		responseDto.setBankName(bank.getBankName());
		responseDto.setIfscCode(bank.getIfscCode());
		responseDto.setBranchName(bank.getBranchName());
		responseDto.setAccountNumber(bank.getAccountNumber());
		responseDto.setUpiId(bank.getUpiId());

		return responseDto;
	}

	public List<BankResponseDto> toList(List<Bank> list) {
		List<BankResponseDto> dtos = new ArrayList<>();
		for (Bank entity : list) {
			dtos.add(toBankResponseDto(entity));
		}
		return dtos;

	}

}
