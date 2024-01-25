package com.dairy.dto.FarmerAnimalMapping;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FarmerAnimalMappingRequestDto {
	private Long id;
	private String type;
	private int count;
	private String status;
	private Long farmerId;
	private int branchId;

}
