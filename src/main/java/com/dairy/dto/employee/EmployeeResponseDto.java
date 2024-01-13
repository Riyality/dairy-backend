package com.dairy.dto.employee;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
	private Long id;
	
	@NotBlank(message = "Employee Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	@NotBlank(message = "contact cannot be blank")
	@Size(max=16,message = "maximum allowed characters are 16")
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
