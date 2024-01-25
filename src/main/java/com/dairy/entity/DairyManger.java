package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "dairy_manger" )
public class DairyManger {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@JoinColumn(name="person_id")
	private int personId;
	private LocalDateTime dateTransaction;
	private String transactionType;
	private String contact;
	private Long amount;
	private Long balance;
	private String remark;
	

}
