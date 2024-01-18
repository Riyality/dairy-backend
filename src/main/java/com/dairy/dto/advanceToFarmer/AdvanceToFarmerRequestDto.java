package com.dairy.dto.advanceToFarmer;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceToFarmerRequestDto {
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dateOfAdvance;
	private Float amount;
	private Float deduction;
	private Float remainingAmount;
	private Long farmerId;
    private int branchId;
}
