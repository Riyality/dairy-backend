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
@Table( name = "farmers" )
public class Farmer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	private String name;

	@Column( name = "date_of_registration" )
	private LocalDateTime dateOfRegistration;

	private String contact;

	@ManyToOne
	@JoinColumn( name = "route" )
	private Route route;

	private String address;

	private String status;

	@ManyToOne
	@JoinColumn( name = "bank" )
	private Bank bank;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;

}
