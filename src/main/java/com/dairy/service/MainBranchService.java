package com.dairy.service;

import java.util.List;

import com.dairy.dto.mainBranch.MainBranchRequestDto;
import com.dairy.dto.mainBranch.MainBranchResponseDto;

public interface MainBranchService {

	boolean addMainBranch(MainBranchRequestDto requestDto);

	List<MainBranchResponseDto> getAllMainBranch();

	MainBranchResponseDto findByIdMainBranch(long id);

	boolean updateMainBranch(MainBranchRequestDto requestDto);

}
