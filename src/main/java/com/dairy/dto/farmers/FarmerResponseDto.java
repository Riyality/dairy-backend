package com.dairy.dto.farmers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dairy.dto.bankdetails.BankResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmerResponseDto {

	private Long id;
	@NotBlank(message = "Farmer Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	
	private LocalDateTime dateOfRegistration;
	
	@NotBlank(message = "Farmer contact cannot be blank")
	private String contact;
	
	@NotBlank(message = "route cannot be blank")
	private String route;
	
	private String address;
	private String status;
	private int branchId;
	private BankResponseDto bank;

}
