package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "main_branch")
public class MainBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
    private String name;
	private LocalDateTime dateOfCollection;
	private String shift;
	private String type;
	private Float quantity;
	private Float fat;
	private Float snf;
	private Float protein ;
	private Float rate;
	private String remark;
	private Float totalAmount;

}
