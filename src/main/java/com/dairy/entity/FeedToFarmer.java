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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "feed_to_farmer")
public class FeedToFarmer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date_of_purchase")
	private LocalDateTime dateOfPurchase;

	private int quantity;

	@Column(name = "feed_rate")
	private Float feedRate;

	@Column(name = "total_amount")
	private Float totalAmount;

	@Column(name = "payment_status")
	private String paymentStatus;

	private String remark;

	@ManyToOne
	@JoinColumn(name = "farmer")
	private Farmer farmer;

	@ManyToOne
	@JoinColumn(name = "branch")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "feed_company")
	private FeedCompany feedCompany;

	@ManyToOne
	@JoinColumn(name = "feed_type")
	private FeedType feedType;
}
