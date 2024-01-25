package com.dairy.mapper.dairyMangerUpdates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesRequestDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesResponseDto;
import com.dairy.entity.DairyMangerUpdate;
import com.dairy.mapper.dairyManger.DairyManagerMapper;

@Component
public class DairyMangerUpdatesMapper {

	@Autowired
	private DairyManagerMapper dairyManagerMapper;

	public DairyMangerUpdate toEntity(DairyMangerUpdatesRequestDto requestDTO) {
		if (requestDTO == null) {
			return null;
		}

		DairyMangerUpdate dairyMangerUpdate = new DairyMangerUpdate();
		dairyMangerUpdate.setId(requestDTO.getId());
		dairyMangerUpdate.setDateTransaction(requestDTO.getDateTransaction());
		dairyMangerUpdate.setTransactionType(requestDTO.getTransactionType());
		dairyMangerUpdate.setBalance(requestDTO.getBalance());
		dairyMangerUpdate.setRemark(requestDTO.getRemark());
		return dairyMangerUpdate;
	}

	public DairyMangerUpdatesResponseDto toResponseDTO(DairyMangerUpdate dairyMangerUpdates) {
		DairyMangerUpdatesResponseDto responseDTO = new DairyMangerUpdatesResponseDto();
		responseDTO.setId(dairyMangerUpdates.getId());
		responseDTO.setDateTransaction(dairyMangerUpdates.getDateTransaction());
		responseDTO.setTransactionType(dairyMangerUpdates.getTransactionType());
		responseDTO.setBalance(dairyMangerUpdates.getBalance());
		responseDTO.setRemark(dairyMangerUpdates.getRemark());

		if (dairyMangerUpdates.getDairyManger() != null) {
			responseDTO.setDairyManagerResponseDto(
					dairyManagerMapper.toDairyManagerResponseDto(dairyMangerUpdates.getDairyManger()));
		}

		return responseDTO;
	}

	public List<DairyMangerUpdatesResponseDto> toList(List<DairyMangerUpdate> list) {
		List<DairyMangerUpdatesResponseDto> dtos = new ArrayList<>();
		for (DairyMangerUpdate entity : list) {
			dtos.add(toResponseDTO(entity));
		}
		return dtos;

	}

}
