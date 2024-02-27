package com.dairy.mapper.mainBranch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.mainBranch.MainBranchRequestDto;
import com.dairy.dto.mainBranch.MainBranchResponseDto;
import com.dairy.entity.MainBranch;

@Component
public class MainBranchMapper {
	public MainBranch toEntity(MainBranchRequestDto mainBranchRequestDto) {
		if (mainBranchRequestDto == null) {
			return null;
		}

		MainBranch mainBranch = new MainBranch();
		mainBranch.setId(mainBranchRequestDto.getId());
		mainBranch.setName(mainBranchRequestDto.getName());
		mainBranch.setDateOfCollection(mainBranchRequestDto.getDateOfCollection());
		mainBranch.setShift(mainBranchRequestDto.getShift());
		mainBranch.setType(mainBranchRequestDto.getType());
		mainBranch.setQuantity(mainBranchRequestDto.getQuantity());
		mainBranch.setFat(mainBranchRequestDto.getFat());
		mainBranch.setSnf(mainBranchRequestDto.getSnf());
		mainBranch.setProtein(mainBranchRequestDto.getProtein());
		mainBranch.setRate(mainBranchRequestDto.getRate());
		mainBranch.setTotalAmount(mainBranchRequestDto.getTotalAmount());
		mainBranch.setRemark(mainBranchRequestDto.getRemark());

		return mainBranch;

	}

	public MainBranchResponseDto toMainBranchResponseDto(MainBranch mainBranch) {
		if (mainBranch == null) {
			return null;
		}
		MainBranchResponseDto mainBranchResponseDto = new MainBranchResponseDto();
		mainBranchResponseDto.setId(mainBranch.getId());
		mainBranchResponseDto.setName(mainBranch.getName());
		mainBranchResponseDto.setDateOfCollection(mainBranch.getDateOfCollection());
		mainBranchResponseDto.setShift(mainBranch.getShift());
		mainBranchResponseDto.setType(mainBranch.getType());
		mainBranchResponseDto.setQuantity(mainBranch.getQuantity());
		mainBranchResponseDto.setFat(mainBranch.getFat());
		mainBranchResponseDto.setSnf(mainBranch.getSnf());
		mainBranchResponseDto.setProtein(mainBranch.getProtein());
		mainBranchResponseDto.setRate(mainBranch.getRate());
		mainBranchResponseDto.setTotalAmount(mainBranch.getTotalAmount());
		mainBranchResponseDto.setRemark(mainBranch.getRemark());

		return mainBranchResponseDto;

	}

	public List<MainBranchResponseDto> toList(List<MainBranch> list) {
		List<MainBranchResponseDto> dtos = new ArrayList<>();
		for (MainBranch entity : list) {
			dtos.add(toMainBranchResponseDto(entity));
		}
		return dtos;

	}

}
