package com.dairy.dto.employee;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dairy.dto.bankdetails.BankRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
	
	private Long id;
	@NotBlank(message = "Farmer Name cannot be blank")
	
	@NotBlank(message = "Employee Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	
	@NotBlank(message = "contact cannot be blank")
	@Size(max=16,message = "maximum allowed characters are 16")
	private String contact;
	
	private String address;
	
	@NotBlank(message = "date Of Joining cannot be blank")
	private LocalDateTime dateOfJoining;
	
	private int branchId;
	
	private BankRequestDto bankRequestDto;
	
}
 