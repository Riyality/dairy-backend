package com.dairy.dto.feedDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedDetailsRequestDto {

	private int id;
	private long feedTypeId;
	private long feedCompanyId;
	private double quantity;
	private int branchId;
}
