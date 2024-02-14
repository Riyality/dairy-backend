package com.dairy.dto.advanceToFarmer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceToFarmerResponseDto {
	private Long id;
	private LocalDate dateOfAdvance;
	private Float amount;
	
	private Float remainingAmount;
	private Long farmerId;
	private String farmerName;
	private int branchId;

}
