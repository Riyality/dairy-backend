package com.dairy.dto.feedStock;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedStockRequestDto {

	private int id;
	private LocalDateTime dateOfPurchase;
	private Float feedCostPerUnit;
	private int quantity;
	private Float totalAmount;
	private long supplierId;
	private long feedTypeId;
	private long feedCompanyId;

}
