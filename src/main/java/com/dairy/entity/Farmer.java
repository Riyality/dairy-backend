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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Farmer Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;

	@Column( name = "date_of_registration" )
	private LocalDateTime dateOfRegistration;

	@NotBlank(message = "Farmer contact cannot be blank")
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
