package com.dairy.mapper.paymentToFarmer;

import org.springframework.stereotype.Component;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.entity.PaymentToFarmer;

@Component
public class PaymentToFarmerMapper {

	
	public PaymentToFarmer toEntity(PaymentToFarmerRequestDto requestdto) {

		if (requestdto == null) {
			return null;
		}
		PaymentToFarmer paymentToFarmer = new PaymentToFarmer();

		
		paymentToFarmer.setInvoice_date(requestdto.getInvoice_date());
		paymentToFarmer.setFrom_date(requestdto.getFrom_date());
		paymentToFarmer.setTo_date(requestdto.getTo_date());	
		paymentToFarmer.setAmount(requestdto.getAmount());
		//paymentToFarmer.setFarmer(requestdto.getFarmer());
		//paymentToFarmer.setBranch(requestdto.getBranch().getId());
		
		paymentToFarmer.setTotal_collected_milk(requestdto.getTotal_collected_milk());
		paymentToFarmer.setMilktype(requestdto.getMilktype());
		paymentToFarmer.setFeed_deduction(requestdto.getFeed_deduction());
		paymentToFarmer.setAdvance_deduction(requestdto.getAdvance_deduction());
		
		paymentToFarmer.setPayment_method(requestdto.getPayment_method());
		paymentToFarmer.setPayment_note(requestdto.getPayment_note());
		return paymentToFarmer;

	}
}
