package com.dairy.dto.FarmerAnimalMapping;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FarmerAnimalMappingResponseDto {
       private Long id;
	    private String type;
	    private int count;
	    private String status;
	    private int branchId;
	    private Long farmerId;
	    private String farmerName;
}
