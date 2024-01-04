package com.dairy.dto.supplier;

import java.time.LocalDateTime;

import com.dairy.dto.bankdetails.BankRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequestDto {
	private Long id;
	private String name;
	private String contact;
	private LocalDateTime dateOfRegistration;
	private String address;
	private BankRequestDto bankRequestDto;
}
