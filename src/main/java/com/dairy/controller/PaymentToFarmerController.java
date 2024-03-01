
package com.dairy.controller;


import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerResponseDto;
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


	@GetMapping("all/{branchId}")
	public ResponseEntity<List<PaymentToFarmerResponseDto>> getAllPaymentList(@PathVariable int branchId ) {
		return new ResponseEntity<>(paymentToFarmerService.getAllPaymentList(branchId), HttpStatus.OK);
	}
	
	@GetMapping("datewise/{fromDate}/{toDate}/{milkType}/{branchId}")
	public ResponseEntity<List<PaymentToFarmerResponseDto>> getPaymentListBetweenFromDateAndToDate(
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
    		@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,
    		@PathVariable String milkType,
    		@PathVariable int branchId) {
		return new ResponseEntity<>(paymentToFarmerService.getPaymentListBetweenFromDateAndToDate(fromDate,toDate,milkType,branchId), HttpStatus.OK);
	}
	
	

}
