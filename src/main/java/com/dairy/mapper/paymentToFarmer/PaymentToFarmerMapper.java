package com.dairy.mapper.paymentToFarmer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerResponseDto;
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
	
	
	public PaymentToFarmerResponseDto toResponseDto( PaymentToFarmer payment ) {
		
		PaymentToFarmerResponseDto responseDto = new PaymentToFarmerResponseDto();
		responseDto.setId( payment.getId() );
		responseDto.setInvoice_date(payment.getInvoice_date());
		responseDto.setFrom_date(payment.getFrom_date());
		responseDto.setTo_date(payment.getTo_date());
		responseDto.setAmount(payment.getAmount());
		responseDto.setFarmer(payment.getFarmer().getId());
		responseDto.setFarmerName(payment.getFarmer().getName());
		responseDto.setBranch(payment.getBranch().getId());
		responseDto.setTotal_collected_milk(payment.getTotal_collected_milk());
		responseDto.setMilktype(payment.getMilktype());
		responseDto.setFeed_deduction(payment.getFeed_deduction());
		responseDto.setAdvance_deduction(payment.getAdvance_deduction());
		responseDto.setPayment_method(payment.getPayment_method());
		responseDto.setPayment_note(payment.getPayment_note());
		
		
		
		return responseDto;

	}
	
	
	
	public List<PaymentToFarmerResponseDto> toList( List<PaymentToFarmer> paymentList ) {
		return paymentList.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}

}
