package com.dairy.dto.farmers;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.dairy.dto.bankdetails.BankRequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmerRequestDto {

	private Long id;
	@NotBlank(message = "Farmer Name cannot be blank")
	
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	
	@DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime dateOfRegistration;
	
	@NotBlank(message = "Farmer contact cannot be blank")
	private String contact;
	private int route;

	private String address;
	
	private String status;
	
	private int branchId;
	private BankRequestDto bankRequestDto;
}
