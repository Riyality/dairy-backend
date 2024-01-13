package com.dairy.dto.farmers;

import java.time.LocalDateTime;

import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.route.RouteResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmerResponseDto {

	private Long id;
	private String name;
	private LocalDateTime dateOfRegistration;
	private String contact;
	private RouteResponseDto route;
	private String address;
	private String status;
	private int branchId;
	private BankResponseDto bank;

}
