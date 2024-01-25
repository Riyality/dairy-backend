package com.dairy.dto.milkCollection;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkCollectionResponseDto {
	private long farmerId;
	private String farmerName;
	private String animalType;
	private Float milkQuantity;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;
	private Float totalMilkAmount;
	private String remark;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date dateOfMilkCollection;
}
