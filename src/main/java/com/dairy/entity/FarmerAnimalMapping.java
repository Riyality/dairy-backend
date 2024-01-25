package com.dairy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "farmer_animal_mapping")
public class FarmerAnimalMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private int count;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="farmer")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;

}
