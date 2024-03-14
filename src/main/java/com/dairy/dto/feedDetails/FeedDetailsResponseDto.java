package com.dairy.dto.feedDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedDetailsResponseDto {

	
	private int id;
	private long feedTypeId;
	private String feedTypeName;
	private long feedCompanyId;
	private String feedCompanyName;
	private double quantity;
	private int branchId;
}
