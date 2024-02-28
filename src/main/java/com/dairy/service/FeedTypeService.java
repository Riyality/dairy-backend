package com.dairy.service;

import java.util.List;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedtype.FeedTypeRequestDto;
import com.dairy.dto.feedtype.FeedTypeResponseDto;

public interface FeedTypeService {

	boolean addFeed(FeedTypeRequestDto dto);

	public List<FeedTypeResponseDto> getAllFeedTypes(int branchId);

	public FeedTypeResponseDto findById(Long id ,int branchId);

	public List<FeedTypeResponseDto> getFeedTypeByFeedCompanyId(long id, int branchId);

	boolean updateFeed(FeedTypeRequestDto dto);

	

}
