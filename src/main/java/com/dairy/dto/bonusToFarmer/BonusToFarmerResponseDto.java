package com.dairy.dto.bonusToFarmer;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BonusToFarmerResponseDto {
	private int id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate bonusDate;
	private float totalQuantity;
	private float bonusAmountPerLiter;
	private float totalBonusAmount;
	private String milkType;
	private Long farmerId;
	private String farmerName; 
	private int branchId;
    private String branchName;
}
