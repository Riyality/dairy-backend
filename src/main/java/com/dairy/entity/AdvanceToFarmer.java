package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
@Table(name="advance_to_farmer")
public class AdvanceToFarmer {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "id" )
	private Long id;
	private LocalDateTime dateOfAdvance;
	private Float amount;
	private Float deduction;
	private Float remainingAmount;
	
	@ManyToOne
	@JoinColumn(name="farmer")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;
	

}
