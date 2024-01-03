package com.dairy.mapper.feedcompany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;
import com.dairy.entity.FeedCompany;

@Component
public class FeedCompanyMapper {

	public FeedCompany toEntity(FeedCompanyRequestDto feedCompanyRequestDto) {

		if (feedCompanyRequestDto == null) {
			return null;

		}

		FeedCompany feedCompany = new FeedCompany();
		feedCompany.setId(feedCompanyRequestDto.getId());
		feedCompany.setName(feedCompanyRequestDto.getName());
		return feedCompany;

	}

	public FeedCompanyResponseDto toFeedCompanyResponce(FeedCompany feedcompany) {

		FeedCompanyResponseDto feedCompanyResponseDto = new FeedCompanyResponseDto();
		feedCompanyResponseDto.setId(feedcompany.getId());
		feedCompanyResponseDto.setName(feedcompany.getName());

		return feedCompanyResponseDto;
	}

	public List<FeedCompanyResponseDto> toList(List<FeedCompany> list) {
		List<FeedCompanyResponseDto> dtos = new ArrayList<>();
		for (FeedCompany feedcompany : list) {
			dtos.add(toFeedCompanyResponce(feedcompany));
		}
		return dtos;

	}

}
