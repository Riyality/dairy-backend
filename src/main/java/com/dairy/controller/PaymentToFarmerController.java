package com.dairy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.service.PaymentToFarmerService;

@RestController
@RequestMapping("/paymentTofarmer")
public class PaymentToFarmerController {

	@Autowired
	PaymentToFarmerService paymentToFarmerService;
	
	
	@PostMapping
	public ResponseEntity<String> addAdvance(@RequestBody PaymentToFarmerRequestDto paymentToFarmerRequestDto) {
	
		System.out.println(paymentToFarmerRequestDto);
		boolean added = paymentToFarmerService.addPayment(paymentToFarmerRequestDto);
		if (added)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_PAYMENT_SUCCESS_MESSAGE);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_PAYMENT_ERROR_MSG);
	}
	
	
	

}
