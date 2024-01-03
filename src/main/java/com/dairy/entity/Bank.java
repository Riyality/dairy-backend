package com.dairy.entity;

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
@Table(name = "bank_details")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String bankName;
	
	private String ifscCode;
	
	private String branchName;
	
	private String accountNumber;
	
	private String upiId;

}
