package com.dairy.entity;

import java.time.LocalDate;

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
@Table(name = "feed_stock")
@Entity
public class FeedStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	private LocalDate dateOfPurchase;
	
	private Float feedCostPerUnit;
	
	private int quantity;
	
	private String remark;
	
	private Float totalAmount;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "vendor")
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "feed_company")
	private FeedCompany feedCompany;

	@ManyToOne
	@JoinColumn(name = "feed_type")
	private FeedType feedType;

}
