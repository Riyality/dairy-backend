package com.dairy.dto.feedToFarmer;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedToFarmerRequestDto {
	private Long id;
	private LocalDateTime dateOfPurchase;
	private Integer quantity;
	private Float feedRate;
	private Float totalAmount;
	private String paymentStatus;
	private String remark;
	private Long farmerId;
	private Integer branchId;
	private Long feedCompanyId;
	private Long feedTypeId;

}
