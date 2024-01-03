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

	private String name;

	private String contact;

	private String address;

	private LocalDateTime dateOfJoining;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name="bank")
	private Bank bank;

}
