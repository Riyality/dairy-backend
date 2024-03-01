
package com.dairy.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.service.MilkCollectionService;
import com.dairy.service.PaymentToFarmerService;

@RestController
@RequestMapping("/paymentTofarmer")
public class PaymentToFarmerController {

	@Autowired
	PaymentToFarmerService paymentToFarmerService;
	@Autowired
	private MilkCollectionService milkCollectionService;
	
	@PostMapping
	public ResponseEntity<String> addPayment(@RequestBody PaymentToFarmerRequestDto dto, HttpSession session) {
	
	        boolean added = paymentToFarmerService.addPayment(dto);
	        if (added) {       
	        	MilkCollectionRequestDto milkCollection=new MilkCollectionRequestDto();	        
	        	milkCollection.setFarmerId((long) dto.getFarmer().intValue());
	        	milkCollection.setBranchId(dto.getBranch());
	        	milkCollection.setAnimalType(dto.getMilktype());
	        	milkCollectionService.updatePaymentStatusbyFarmerIdBranchIdAndMilktype(milkCollection );      
	        	return ResponseEntity.status(HttpStatus.OK).body(MessageConstants.ADD_PAYMENT_SUCCESS_MESSAGE);	        	
	        }
			return null;

	   
	}


		

}
