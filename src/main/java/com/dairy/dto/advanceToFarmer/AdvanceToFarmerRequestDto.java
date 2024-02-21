package com.dairy.dto.advanceToFarmer;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceToFarmerRequestDto {
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAdvance;
	private Float amount;
	private Float remainingAmount;
	private Long farmerId;
    private int branchId;
    private String remark;
}
