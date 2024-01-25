package com.dairy.mapper.dairyManger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.dairyManger.DairyManagerRequestDto;
import com.dairy.dto.dairyManger.DairyManagerResponseDto;
import com.dairy.entity.DairyManger;

@Component
public class DairyManagerMapper {
	public DairyManger toEntity(DairyManagerRequestDto dairyManagerRequestDto) {
		if (dairyManagerRequestDto == null) {
			return null;
		}

		DairyManger dairyManager = new DairyManger();
		dairyManager.setId(dairyManagerRequestDto.getId());
		dairyManager.setName(dairyManagerRequestDto.getName());
		dairyManager.setDateTransaction(dairyManagerRequestDto.getDateTransaction());
		dairyManager.setPersonId(dairyManagerRequestDto.getPersonId());
		dairyManager.setTransactionType(dairyManagerRequestDto.getTransactionType());
		dairyManager.setContact(dairyManagerRequestDto.getContact());
		dairyManager.setAmount(dairyManagerRequestDto.getAmount());
		dairyManager.setRemark(dairyManagerRequestDto.getRemark());

		return dairyManager;
	}

	public DairyManagerResponseDto toDairyManagerResponseDto(DairyManger dairyManager) {
		if (dairyManager == null) {
			return null;
		}
		DairyManagerResponseDto responseDto = new DairyManagerResponseDto();
		responseDto.setId(dairyManager.getId());
		responseDto.setName(dairyManager.getName());
		responseDto.setDateTransaction(dairyManager.getDateTransaction());
		responseDto.setPersonId(dairyManager.getPersonId());
		responseDto.setTransactionType(dairyManager.getTransactionType());
		responseDto.setContact(dairyManager.getContact());
		responseDto.setAmount(dairyManager.getAmount());
		responseDto.setRemark(dairyManager.getRemark());
		return responseDto;

	}

	public List<DairyManagerResponseDto> toList(List<DairyManger> list) {
		List<DairyManagerResponseDto> dtos = new ArrayList<>();
		for (DairyManger entity : list) {
			dtos.add(toDairyManagerResponseDto(entity));
		}
		return dtos;

	}
}
