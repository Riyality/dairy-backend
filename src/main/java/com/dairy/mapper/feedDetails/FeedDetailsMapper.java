package com.dairy.mapper.feedDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedDetails.FeedDetailsRequestDto;
import com.dairy.dto.feedDetails.FeedDetailsResponseDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedDetails;
import com.dairy.entity.FeedStock;
import com.dairy.entity.FeedType;


@Component
public class FeedDetailsMapper {

	
	 public FeedDetails toEntity(FeedDetailsRequestDto requestDto) {
	        FeedDetails feedDetails = new FeedDetails();
	        feedDetails.setId(requestDto.getId());

	        FeedCompany feedCompany = new FeedCompany();
	        feedCompany.setId(requestDto.getFeedCompanyId());
	        feedDetails.setFeedCompany(feedCompany);

	        FeedType feedType = new FeedType();
	        feedType.setId(requestDto.getFeedTypeId());
	        feedDetails.setFeedType(feedType);

	        feedDetails.setQuantity(requestDto.getQuantity());

	        Branch branch = new Branch();
	        branch.setId(requestDto.getBranchId());
	        feedDetails.setBranch(branch);

	        return feedDetails;
	    }

	 
	 
	 
	 public FeedDetailsResponseDto toFeedDetailsResponseDto(FeedDetails feedDetails) {
			if (feedDetails == null) {
				return null;
			}

			FeedDetailsResponseDto responseDto = new FeedDetailsResponseDto();
			responseDto.setId(feedDetails.getId());
		
			if (feedDetails.getBranch() != null) {
				responseDto.setBranchId(feedDetails.getBranch().getId());
			}
			if (feedDetails.getFeedType() != null) {
				responseDto.setFeedTypeId(feedDetails.getFeedType().getId());
				responseDto.setFeedTypeName(feedDetails.getFeedType().getType());
			}
			if (feedDetails.getFeedCompany() != null) {
				responseDto.setFeedCompanyId(feedDetails.getFeedCompany().getId());
				responseDto.setFeedCompanyName(feedDetails.getFeedCompany().getName());
			}
			responseDto.setQuantity(feedDetails.getQuantity());
			return responseDto;
		}
	 
	 
	 
	 
	public List<FeedDetailsResponseDto> toList(List<FeedDetails> feedDetails) {
	
		List<FeedDetailsResponseDto> dtos = new ArrayList<>();
		for (FeedDetails entity : feedDetails) {
			dtos.add(toFeedDetailsResponseDto(entity));
		}
		return dtos;
		
	}
	
}
