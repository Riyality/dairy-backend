package com.dairy.dto.paymentToFarmer;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentToFarmerResponseDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate invoice_date;
	
	private LocalDate from_date;
	private LocalDate to_date;
	private float amount;
	

	private Long farmer;
	
	private String farmerName;

	private int branch;
	
	private Long total_collected_milk;
	private String milktype;
	
	private float feed_deduction;
	private float advance_deduction;
	private String payment_method;
	private String payment_note;

}
