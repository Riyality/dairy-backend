package com.dairy.dto.feedStock;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedStockResponseDto {
	private int id;
	private LocalDate dateOfPurchase;
	private Float feedCostPerUnit;
	private int quantity;
	private Float totalAmount;
	private int branchId;
	
	private Long supplierId;
	private String supplierName;
	private Long feedTypeId;
	private String feedTypeName;
	private Long feedCompanyId;
	private String feedCompanyName;
	private String remark;
	
	

}
