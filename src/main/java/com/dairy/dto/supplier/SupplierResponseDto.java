package com.dairy.dto.supplier;

import java.time.LocalDateTime;

import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.employee.EmployeeResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponseDto {
	private Long id;
	private String name;
	private String contact;
	private LocalDateTime dateOfRegistration;
	private String address;
	
	private long bankId;

	private String bankName;
	private String ifscCode;
	private String bankBranchName;
	private String accountNumber;
	private String upiId;



}
