package com.dairy.service;

import java.util.List;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;

public interface FeedCompanyService {

	boolean addFeedCompany(FeedCompanyRequestDto dto);

	public FeedCompanyResponseDto findById(Long id);

	List<FeedCompanyResponseDto> findAll();

}
