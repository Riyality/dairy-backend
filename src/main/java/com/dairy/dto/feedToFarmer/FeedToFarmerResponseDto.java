package com.dairy.dto.feedToFarmer;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedToFarmerResponseDto {
	private Long id;
	private LocalDateTime dateOfPurchase;
	private Integer quantity;
	private Float feedRate;
	private Float totalAmount;
	private String paymentStatus;
	private String remark;
	private Integer branchId;
	
	private Long farmerId;
	private String farmerName;
	
	private Long feedCompanyId;
	private String feedCompanyName;
	
	private Long feedTypeId;
	private String feedTypeName;

}
