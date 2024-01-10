package com.dairy.dto.milkCollection;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkCollectionResponseDto {
	private int farmerId;
	private String farmerName;
	private String animalType;
	private Float milkQuantity;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;
	private Float totalMilkAmount;
	private String remark;
	private LocalDateTime dateOfMilkCollection;
}
