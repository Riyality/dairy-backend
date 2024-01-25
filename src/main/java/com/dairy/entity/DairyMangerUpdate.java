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
@Table(name = "dairy_manger_update")
public class DairyMangerUpdate{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dateTransaction;
	private String transactionType;
	private Float balance;
	private String remark;

	@ManyToOne
	@JoinColumn(name = "dairy_manger")
	private DairyManger dairyManger;

	

}
