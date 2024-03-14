package com.dairy.entity;

import javax.persistence.Column;
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
@Table(name = "feed_details")
@Entity
public class FeedDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "feed_company")
	private FeedCompany feedCompany;

	@ManyToOne
	@JoinColumn(name = "feed_type")
	private FeedType feedType;
	
	private double quantity;

	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;


}
