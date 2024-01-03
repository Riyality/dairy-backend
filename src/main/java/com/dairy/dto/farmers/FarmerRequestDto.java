package com.dairy.dto.farmers;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.dairy.dto.bankdetails.BankRequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmerRequestDto {

	private Long id;
	private String name;
	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime dateOfRegistration;
	private String contact;
	private String route;
	private String address;
	private String status;
	private int branchId;
	private BankRequestDto bankRequestDto;
}
