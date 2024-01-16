package com.dairy.dto.milkRate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkRateResponseDto {
	
	private int milkRateId;
	private String animalType;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;

}
