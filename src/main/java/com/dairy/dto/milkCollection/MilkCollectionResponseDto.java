package com.dairy.dto.milkCollection;

import java.time.LocalDate;
import java.util.Date;

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
	private Date dateOfMilkCollection;
	private String branchName;
	

}
