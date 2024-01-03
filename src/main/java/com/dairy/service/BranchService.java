package com.dairy.service;

import java.util.List;

import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;

public interface BranchService {
	List<BranchResponseDto> getAllBranches();

	boolean createBranch( BranchRequestDto dto );

	BranchResponseDto findById( int id );

	boolean updateBranch( BranchRequestDto dto );
}
