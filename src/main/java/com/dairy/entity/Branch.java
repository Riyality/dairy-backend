package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "branch" )
@Entity
public class Branch {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "id" )
	private int id;

	private String name;

	private String address;

	private String owner;

	private String ownerContact;

	private LocalDateTime startDate;
}
