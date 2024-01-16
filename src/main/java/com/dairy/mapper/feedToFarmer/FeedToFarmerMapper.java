package com.dairy.mapper.feedToFarmer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;
import com.dairy.entity.FeedToFarmer;

@Component
public class FeedToFarmerMapper {
	public FeedToFarmer toEntity(FeedToFarmerRequestDto feedToFarmerRequestDto){
		
	   if(feedToFarmerRequestDto==null){
		   return null;
	   }
	   
	   FeedToFarmer feedToFarmer=new FeedToFarmer();
	   
	   feedToFarmer.setId(feedToFarmerRequestDto.getId());
	   feedToFarmer.setDateOfPurchase(feedToFarmerRequestDto.getDateOfPurchase());
	   feedToFarmer.setQuantity(feedToFarmerRequestDto.getQuantity());
	   feedToFarmer.setFeedRate(feedToFarmerRequestDto.getFeedRate());
	   feedToFarmer.setTotalAmount(feedToFarmerRequestDto.getTotalAmount());
	   feedToFarmer.setPaymentStatus(feedToFarmerRequestDto.getPaymentStatus());
	   feedToFarmer.setRemark(feedToFarmerRequestDto.getRemark());
		return feedToFarmer;
		
	}
	
	public FeedToFarmerResponseDto toFeedToFarmerResponseDto(FeedToFarmer feedToFarmer){
		
		if(feedToFarmer==null){
			return null;
		}
		
		FeedToFarmerResponseDto feedToFarmerResponseDto=new FeedToFarmerResponseDto();
		feedToFarmerResponseDto.setId(feedToFarmer.getId());
		feedToFarmerResponseDto.setDateOfPurchase(feedToFarmer.getDateOfPurchase());
		feedToFarmerResponseDto.setQuantity(feedToFarmer.getQuantity());
		feedToFarmerResponseDto.setFeedRate(feedToFarmer.getFeedRate());
		feedToFarmerResponseDto.setTotalAmount(feedToFarmer.getTotalAmount());
		feedToFarmerResponseDto.setPaymentStatus(feedToFarmer.getPaymentStatus());
		feedToFarmerResponseDto.setRemark(feedToFarmer.getRemark());
		
		if(feedToFarmer.getBranch()!=null){
			feedToFarmerResponseDto.setBranchId(feedToFarmer.getBranch().getId());
		}
		if(feedToFarmer.getFarmer()!=null){
			feedToFarmerResponseDto.setFarmerId(feedToFarmer.getFarmer().getId());
			feedToFarmerResponseDto.setFarmerName(feedToFarmer.getFarmer().getName());
		}
		if(feedToFarmer.getFeedCompany()!=null){
			feedToFarmerResponseDto.setFeedCompanyId(feedToFarmer.getFeedCompany().getId());
			feedToFarmerResponseDto.setFeedCompanyName(feedToFarmer.getFeedCompany().getName());
		}
		if(feedToFarmer.getFeedType()!=null){
			feedToFarmerResponseDto.setFeedTypeId(feedToFarmer.getFeedType().getId());
			feedToFarmerResponseDto.setFeedTypeName(feedToFarmer.getFeedType().getType());
		}
		
        
		return feedToFarmerResponseDto;
		
	}
	
	public List<FeedToFarmerResponseDto> toList(List<FeedToFarmer> list){
		List<FeedToFarmerResponseDto> dtos= new ArrayList<>();
		for(FeedToFarmer entity:list){
		dtos.add(toFeedToFarmerResponseDto(entity));
		}
		return dtos;
		
		
	}

}
