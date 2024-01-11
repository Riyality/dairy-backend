package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "employee" )
public class Employee {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@NotBlank(message = "Employee Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	
	@NotBlank(message = "contact cannot be blank")
	@Size(max=16,message = "maximum allowed characters are 16")
	private String contact;

	private String address;
	
	@NotBlank(message = "date Of Joining cannot be blank")
	private LocalDateTime dateOfJoining;
	
	@NotBlank(message = "branch cannot be blank")
	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name="bank")
	private Bank bank;

}
