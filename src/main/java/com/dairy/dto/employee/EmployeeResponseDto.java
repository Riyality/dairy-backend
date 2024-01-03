package com.dairy.dto.employee;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
	private Long id;
	private String name;
	private String contact;
	private String address;
	private LocalDateTime dateOfJoining;
	private int branchId;
	private String branchName;
	private long bankId;

	private String bankName;
	private String ifscCode;
	private String bankBranchName;
	private String accountNumber;
	private String upiId;



}
