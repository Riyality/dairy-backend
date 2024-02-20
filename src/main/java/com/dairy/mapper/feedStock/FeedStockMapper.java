package com.dairy.mapper.feedStock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.feedStock.FeedStockRequestDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;
import com.dairy.entity.FeedStock;

@Component
public class FeedStockMapper {

	public FeedStock toEntity(FeedStockRequestDto requestDto) {
		FeedStock feedStock = new FeedStock();
		feedStock.setId(requestDto.getId());
		feedStock.setDateOfPurchase(requestDto.getDateOfPurchase());
		feedStock.setFeedCostPerUnit(requestDto.getFeedCostPerUnit());
		feedStock.setQuantity(requestDto.getQuantity());
		feedStock.setTotalAmount(requestDto.getTotalAmount());
		feedStock.setRemark(requestDto.getRemark());

		return feedStock;

	}

	public FeedStockResponseDto toFeedStockResponseDto(FeedStock feedStock) {
		if (feedStock == null) {
			return null;
		}

		FeedStockResponseDto responseDto = new FeedStockResponseDto();
		responseDto.setId(feedStock.getId());
		responseDto.setDateOfPurchase(feedStock.getDateOfPurchase());
		responseDto.setFeedCostPerUnit(feedStock.getFeedCostPerUnit());
		responseDto.setQuantity(feedStock.getQuantity());
		responseDto.setTotalAmount(feedStock.getTotalAmount());
		responseDto.setRemark(feedStock.getRemark());
		
		if (feedStock.getBranch() != null) {
			responseDto.setBranchId(feedStock.getBranch().getId());
		}

		
		if (feedStock.getSupplier() != null) {
			responseDto.setSupplierId(feedStock.getSupplier().getId());
			responseDto.setSupplierName(feedStock.getSupplier().getName());
		}
		
		if (feedStock.getFeedType() != null) {
			responseDto.setFeedTypeId(feedStock.getFeedType().getId());
			responseDto.setFeedTypeName(feedStock.getFeedType().getType());
		}
		
		if (feedStock.getFeedCompany() != null) {
			responseDto.setFeedCompanyId(feedStock.getFeedCompany().getId());
			responseDto.setFeedCompanyName(feedStock.getFeedCompany().getName());
		}

		return responseDto;
	}

	public List<FeedStockResponseDto> toList(List<FeedStock> list) {
		List<FeedStockResponseDto> dtos = new ArrayList<>();
		for (FeedStock entity : list) {
			dtos.add(toFeedStockResponseDto(entity));
		}
		return dtos;

	}

}
