package com.dairy.dto.feedToFarmer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedToFarmerResponseDto {
	private Long id;
	private LocalDate dateOfPurchase;
	private Integer quantity;
	private Float feedRate;
	private Float totalAmount;
	private Float paidAmount;
	private Float remainingAmount;
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
