package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Table(name="equipment")
@Entity
public class Equipment {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;
    private LocalDateTime dateOfPurchase;
    private Integer quantity;
    private Float price;
    private Float totalAmount;
}
