package com.dairy.dto.farmers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.route.RouteResponseDto;

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
	private RouteResponseDto route;
	private String address;
	private String status;
	private String remark;
	private int branchId;
	private BankResponseDto bank;

}
