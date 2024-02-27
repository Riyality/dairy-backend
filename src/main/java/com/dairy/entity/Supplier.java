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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "vendor")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String contact;
	private LocalDateTime dateOfRegistration;
	private String address;
	private String remark;
	
    @ManyToOne
    @JoinColumn(name="branch")
    private Branch branch;
	@OneToOne
	@JoinColumn(name = "bank")
	private Bank bank;

}
