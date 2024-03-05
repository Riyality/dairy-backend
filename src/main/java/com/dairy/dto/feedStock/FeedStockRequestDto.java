package com.dairy.dto.feedStock;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedStockRequestDto {

	private int id;
	private LocalDate dateOfPurchase;
	private Float feedCostPerUnit;
	private int quantity;
	private Float totalAmount;
	private long supplierId;
	private long feedTypeId;
	private long feedCompanyId;
	private int branchId;
	private String remark;

}
