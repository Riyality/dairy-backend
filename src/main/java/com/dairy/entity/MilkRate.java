package com.dairy.entity;

import java.time.LocalDateTime;

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
@Table(name = "milk_rate")
public class MilkRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date_of_rate;
	private String type;
	private Float fat;
	private Float snf;
	private Float rate;

	@ManyToOne
	@JoinColumn(name = "branch")
	private Branch branch;

}