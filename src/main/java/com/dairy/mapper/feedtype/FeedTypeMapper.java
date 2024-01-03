package com.dairy.mapper.feedtype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedtype.FeedTypeRequestDto;
import com.dairy.dto.feedtype.FeedTypeResponseDto;
import com.dairy.entity.FeedType;

@Component
public class FeedTypeMapper {

	public FeedType toEntity(FeedTypeRequestDto dto) {
		if (dto == null) {
			return null;
		}
		FeedType feedType = new FeedType();
		feedType.setType(dto.getType());
		return feedType;
	}

	public FeedTypeResponseDto toFeedTypeResponse(FeedType feedType) {
		FeedTypeResponseDto feedTypeResponseDto = new FeedTypeResponseDto();
		feedTypeResponseDto.setId(feedType.getId());
		feedTypeResponseDto.setType(feedType.getType());
		feedTypeResponseDto.setFeedcompanyId(feedType.getFeedcompany().getId());

		return feedTypeResponseDto;

	}

	public List<FeedTypeResponseDto> toList(List<FeedType> list) {
		List<FeedTypeResponseDto> dto = new ArrayList<>();
		for (FeedType feedType : list) {
			dto.add(toFeedTypeResponse(feedType));

		}
		return dto;

	}
}
