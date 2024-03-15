package com.dairy.mapper.feedcompany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;
import com.dairy.dto.route.RouteRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.Route;

@Component
public class FeedCompanyMapper {

	public FeedCompany toEntity(FeedCompanyRequestDto feedCompanyRequestDto) {

		if (feedCompanyRequestDto == null) {
			return null;

		}

		FeedCompany feedCompany = new FeedCompany();
		feedCompany.setId(feedCompanyRequestDto.getId());
		feedCompany.setName(feedCompanyRequestDto.getName());
		feedCompany.setRemark(feedCompanyRequestDto.getRemark());
		return feedCompany;

	}

	public FeedCompanyResponseDto toFeedCompanyResponce(FeedCompany feedcompany) {

		FeedCompanyResponseDto feedCompanyResponseDto = new FeedCompanyResponseDto();
		feedCompanyResponseDto.setId(feedcompany.getId());
		feedCompanyResponseDto.setName(feedcompany.getName());
		feedCompanyResponseDto.setRemark(feedcompany.getRemark());

		if (feedcompany.getBranch() != null) {
			feedCompanyResponseDto.setBranchId(feedcompany.getBranch().getId());
		}
		return feedCompanyResponseDto;
	}

	public List<FeedCompanyResponseDto> toList(List<FeedCompany> list) {
		List<FeedCompanyResponseDto> dtos = new ArrayList<>();
		for (FeedCompany feedcompany : list) {
			dtos.add(toFeedCompanyResponce(feedcompany));
		}
		return dtos;

	}

	public List<FeedCompany> listToentity(List<FeedCompanyRequestDto> dtoList) {
		List<FeedCompany> Feedcompany = new ArrayList<>();
		for(FeedCompanyRequestDto dto : dtoList) {
			Feedcompany.add(toEntitylist(dto));
		}
		return Feedcompany;
	}

	private FeedCompany toEntitylist(FeedCompanyRequestDto dto) {
		FeedCompany feedcompany = new FeedCompany();
		Branch branch = new Branch();
		
		feedcompany.setId(dto.getId());
		feedcompany.setName(dto.getName());
		feedcompany.setRemark(dto.getRemark());
		branch.setId(dto.getBranchId());
		feedcompany.setBranch(branch);
		
		return feedcompany;
	}

}
