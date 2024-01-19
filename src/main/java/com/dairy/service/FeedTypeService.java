package com.dairy.service;

import java.util.List;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedtype.FeedTypeRequestDto;
import com.dairy.dto.feedtype.FeedTypeResponseDto;

public interface FeedTypeService {

	boolean addFeed(FeedTypeRequestDto dto);

	public List<FeedTypeResponseDto> getAllFeedTypes();

	public FeedTypeResponseDto findById(Long id);

	public List<FeedTypeResponseDto> getFeedTypeByFeedCompanyId(int id, int branchId);

	boolean updateFeed(FeedTypeRequestDto dto);

	

}
