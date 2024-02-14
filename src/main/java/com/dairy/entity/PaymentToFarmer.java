package com.dairy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "payment_to_farmer")
public class PaymentToFarmer {
	
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
