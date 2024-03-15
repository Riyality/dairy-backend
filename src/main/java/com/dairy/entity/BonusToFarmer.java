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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

@Table(name="bonus_of_farmer")
public class BonusToFarmer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;
    
    @Column(name = "bonus_date")
    private LocalDate bonusDate;

    @Column(name = "total_quntity")
    private float totalQuantity;

    @Column(name = "bonus_amount_per_liter")
    private float bonusAmountPerLiter;

    @Column(name = "total_bonus_amount")
    private float totalBonusAmount;
     
    @Column(name = "milk_type")
    private String milkType;

    @ManyToOne
    @JoinColumn(name = "farmer")
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;

   
}
