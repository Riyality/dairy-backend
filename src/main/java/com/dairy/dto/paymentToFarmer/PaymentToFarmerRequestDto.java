package com.dairy.dto.paymentToFarmer;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentToFarmerRequestDto {
	
	
	private LocalDate invoice_date;
	private LocalDate from_date;
	private LocalDate to_date;
	private Float amount;
	private Long farmer;

	private int branch;
	private Long total_collected_milk;
	private String milktype;	
	private Float feed_deduction;
	private Float advance_deduction;
	private String payment_method;
	private String payment_note;
	
}
