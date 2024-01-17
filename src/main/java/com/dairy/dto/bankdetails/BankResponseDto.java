package com.dairy.dto.bankdetails;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDto {
	private Long id;

	@NotBlank(message = "Bank Name cannot be blank")
	private String bankName;

	private String ifscCode;

	private String branchName;

	@NotBlank(message = "account Number cannot be blank")
	private String accountNumber;

	private String upiId;
	
	private int branchId;

}
