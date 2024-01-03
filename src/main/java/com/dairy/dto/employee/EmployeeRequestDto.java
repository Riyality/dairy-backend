package com.dairy.dto.employee;

import java.time.LocalDateTime;

import com.dairy.dto.bankdetails.BankRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
	private String name;
	private String contact;
	private String address;
	private LocalDateTime dateOfJoining;
	private int branchId;
	private BankRequestDto bankRequestDto;
}
 