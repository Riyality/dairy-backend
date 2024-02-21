package com.dairy.dto.paymentToFarmer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentToFarmerRequestDto {
	
	

	private Date invoice_date;
	private Date from_date;
	private Date to_date;
	private Long amount;

	private Long farmer;

	private int branch;
	
	private Long total_collected_milk;
	private String milktype;
	
	private Long feed_deduction;
	private Long advance_deduction;
	private String payment_method;
	private String payment_note;
	
}