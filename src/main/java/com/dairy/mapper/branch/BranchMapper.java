package com.dairy.mapper.branch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;

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
		branch.setRemark(branchRequestDto.getRemark());
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
		responseDto.setRemark(branch.getRemark());
		return responseDto;
	}

	public List<BranchResponseDto> toList( List<Branch> list ) {
		List<BranchResponseDto> dtos = new ArrayList<>();
		for ( Branch entity : list ) {
			dtos.add( toBranchResponseDto( entity ) );
		}
		return dtos;

	}

	public Iterable listToentity(List<BranchRequestDto> dto) {
		List<Branch> branch = new ArrayList<>();
		for(BranchRequestDto entity: dto) {
			branch.add(toEntitySave(entity));			
		}
		return branch;
	}

	private Branch toEntitySave(BranchRequestDto entity) {
		Branch branch = new Branch();
		
		branch.setId(entity.getId());
		branch.setName(entity.getName());
		branch.setAddress(entity.getAddress());
		branch.setOwner(entity.getOwner());
		branch.setOwnerContact(entity.getOwnerContact());
		branch.setStartDate(entity.getStartDate());
		branch.setOwnerContact(entity.getOwnerContact());
		branch.setRemark(entity.getRemark());
		return branch;
	}
}
