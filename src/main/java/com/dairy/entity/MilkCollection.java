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
@Table(name = "milk_collection")
public class MilkCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateOfCollection;
	private String shift;
	private String type;
	private Float quantity;
	private Float fat;
	private Float snf;
	private Float rate;
	private Float total_amount;
	private String  payment_status;	
	@ManyToOne
	@JoinColumn(name = "farmer")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name = "branch")
	private Branch branch;


}
