package com.dairy.mapper.branch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.entity.Branch;

@Component
public class BranchMapper {

	public Branch toEntity( BranchRequestDto branchRequestDto ) {
		if ( branchRequestDto == null ) {
			return null;
		}

		Branch branch = new Branch();
		branch.setId( branchRequestDto.getId() );
		branch.setName( branchRequestDto.getName() );
		branch.setAddress( branchRequestDto.getAddress() );
		branch.setOwner( branchRequestDto.getOwner() );
		branch.setOwnerContact( branchRequestDto.getOwnerContact() );
		branch.setStartDate( branchRequestDto.getStartDate() );

		return branch;
	}

	public BranchResponseDto toBranchResponseDto( Branch branch ) {
		if ( branch == null ) {
			return null;
		}

		BranchResponseDto responseDto = new BranchResponseDto();
		responseDto.setId( branch.getId() );
		responseDto.setName( branch.getName() );
		responseDto.setAddress( branch.getAddress() );
		responseDto.setOwner( branch.getOwner() );
		responseDto.setOwnerContact( branch.getOwnerContact() );
		responseDto.setStartDate( branch.getStartDate() );

		return responseDto;
	}

	public List<BranchResponseDto> toList( List<Branch> list ) {
		List<BranchResponseDto> dtos = new ArrayList<>();
		for ( Branch entity : list ) {
			dtos.add( toBranchResponseDto( entity ) );
		}
		return dtos;

	}
}
