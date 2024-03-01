package com.dairy.dto.milkCollection;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkCollectionResponseDto {

	private Long farmerId;
	private String farmerName;
	private String animalType;
	private String shift;
	private Float milkQuantity;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;
	private Float totalMilkAmount;
	private String remark;
	private int branchId;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private LocalDate dateOfMilkCollection;
	private String branchName;
	private Double TotalFeedRemainingAmount;
	private Double TotalAdvanceAmount;
	private String payment_status;
}
