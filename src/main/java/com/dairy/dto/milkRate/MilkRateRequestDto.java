package com.dairy.dto.milkRate;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.entity.Branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkRateRequestDto {

	private int id;
	private String animalType;
	private Float milkFat;
	private Float milkSNF;
	private Float milkRate;
	private String remark;
	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime date_of_rate;
	
	private int branchId;
}
