package com.dairy.entity;

import java.time.LocalDate;

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
	private LocalDate dateOfAdvance;
	private Float amount;
	
	private Float remainingAmount;
	
	@ManyToOne
	@JoinColumn(name="farmer")
	private Farmer farmer;
	private String remark;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;
	

}
