package com.dairy.dto.paymentToFarmer;

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
	
	private Date invoice_date;
	
	private Date from_date;
	private Date to_date;
	private Long amount;
	
	@ManyToOne
	@JoinColumn(name = "farmer")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name = "branch")
	private Branch branch;
	
	private Long total_collected_milk;
	private String milktype;
	
	private Long feed_deduction;
	private Long advance_deduction;
	private String payment_method;
	private String payment_note;

}
