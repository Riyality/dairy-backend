package com.dairy.dto.milkCollection;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkCollectionRequestDto {
	
	private Long farmerId;
	private String farmerName;
	private String animalType;
	private String milkCollectionShift;
	private Float milkQuantity;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;
	private Float totalMilkAmount;
	private String remark;
	private String payment_status;
	private int branchId;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private LocalDate dateOfMilkCollection;


}
