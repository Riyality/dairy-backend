package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.entity.PaymentToFarmer;

@Repository
public interface PaymentToFarmerRepository extends JpaRepository<PaymentToFarmer, Long>{

	
	void save(PaymentToFarmerRequestDto paymentToFarmerRequestDto);

	
}
