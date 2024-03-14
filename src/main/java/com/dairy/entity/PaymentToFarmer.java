
package com.dairy.entity;

import java.time.LocalDate;
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
	
	private LocalDate invoice_date;
	
	private LocalDate from_date;
	private LocalDate to_date;
	private Float amount;
	
	@ManyToOne
	@JoinColumn(name = "farmer")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name = "branch")
	private Branch branch;
	
	private Float total_collected_milk;
	private String milktype;
	
	private Float feed_deduction;
	private Float advance_deduction;
	private String payment_method;
	private String payment_note;
	
	
	
}

