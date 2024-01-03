package com.dairy.dto.bankdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankRequestDto {
	private Long id;

	private String bankName;

	private String ifscCode;

	private String branchName;

	private String accountNumber;

	private String upiId;

}
