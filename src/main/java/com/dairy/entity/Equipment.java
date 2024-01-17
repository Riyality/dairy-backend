package com.dairy.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "equipment Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
    private String name;
    
    private LocalDateTime dateOfPurchase;
    
    private Integer quantity;
    private Float price;
    private Float totalAmount;
    
   @ManyToOne
   @JoinColumn(name="branch")
    private Branch branch;
}
