package com.dairy.dto.advanceToFarmer;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.dairy.dto.bankdetails.BankRequestDto;
import com.dairy.dto.employee.EmployeeRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceToFarmerResponseDto {
	private Long id;
	private LocalDateTime dateOfAdvance;
	private Float amount;
	private Float deduction;
	private Float remainingAmount;
	private Long farmerId;
	private String farmerName;
	private int branchId;

}
