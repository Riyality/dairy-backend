package com.dairy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.bankdetails.BankRequestDto;
import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.employee.EmployeeRequestDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Equipment;
import com.dairy.mapper.bank.BankMapper;
import com.dairy.repository.BankRepository;
import com.dairy.service.BankService;

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class BankServiceImpl implements BankService {
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private  BankMapper bankMapper;


	@Override
	public Bank addBank(BankRequestDto bankRequestDto) {
		try {
			Bank bank = bankMapper.toEntity(bankRequestDto);
			return bankRepository.save(bank);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}


	@Override
	public List<BankResponseDto> getAllBankDetails() {
		List<Bank> banks = bankRepository.findAll();
		return bankMapper.toList(banks);
	}


	@Override
	public Bank updateBank(BankRequestDto bankRequestDto) {
		try {
			Bank bank = bankMapper.toEntity(bankRequestDto);
			return bankRepository.save(bank);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}





	

}
