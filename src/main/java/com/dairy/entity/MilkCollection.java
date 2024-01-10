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

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "milk_collection")
public class MilkCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date_of_collection;
	private String shift;
	private String type;
	private Float quantity;
	private Float fat;
	private Float snf;
	private Float rate;
	private Float total_amount;

	@ManyToOne
	@JoinColumn(name = "farmer")
	private Farmer farmer;


}
