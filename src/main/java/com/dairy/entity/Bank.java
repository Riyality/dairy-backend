package com.dairy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

	@NotBlank(message = "Bank Name cannot be blank")
	private String bankName;
	
	private String ifscCode;
	
	private String branchName;
	
	@NotBlank(message = "account Number cannot be blank")
	private String accountNumber;
	
	private String upiId;
	
	@ManyToOne
	@JoinColumn(name="branch")
	private Branch branch;

}
