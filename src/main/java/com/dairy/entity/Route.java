package com.dairy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "route" )
@Entity
public class Route {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	private String name;
	private String remark;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;
	
	
}