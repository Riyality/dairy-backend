package com.dairy.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.dto.paymentToFarmer.PaymentToFarmerResponseDto;
import com.dairy.entity.AdvanceToFarmer;

import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedToFarmer;
import com.dairy.entity.PaymentToFarmer;
import com.dairy.mapper.paymentToFarmer.PaymentToFarmerMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.repository.FeedToFarmerRepository;
import com.dairy.repository.PaymentToFarmerRepository;

import com.dairy.service.AdvanceToFarmerService;

import com.dairy.service.FeedToFarmerService;
import com.dairy.service.PaymentToFarmerService;

@Service
public class PaymentToFarmerServiceImpl implements PaymentToFarmerService{

	@Autowired
	PaymentToFarmerRepository paymentToFarmerRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private PaymentToFarmerMapper paymentTofarmerMapper;
	
	@Autowired
	private FeedToFarmerRepository feedToFarmerRepository;
	
	
	@Autowired
	FeedToFarmerService feedToFarmerService;
	

	@Autowired 
	AdvanceToFarmerService advanceToFarmerService;


	@Autowired
	private PaymentToFarmerMapper paymentToFarmerMapper;
	
	
	@Override
	public boolean addPayment(PaymentToFarmerRequestDto paymentToFarmerRequestDto) {

	    try {
	        PaymentToFarmer paymentToFarmer = paymentToFarmerMapper.toEntity(paymentToFarmerRequestDto);
	        Optional<Branch> opt = branchRepository.findById(paymentToFarmerRequestDto.getBranch());
	        Optional<Farmer> opt2 = farmerRepository.findById(paymentToFarmerRequestDto.getFarmer());	       
	        if (opt.isPresent() && opt2.isPresent()) {
	            paymentToFarmer.setBranch(opt.get());
	            paymentToFarmer.setFarmer(opt2.get());      
	            updateFeedRemainingAmount(paymentToFarmer);  // Update remaining Amount in FeedToFarmer table	            
	            updateAdvanceAmount(paymentToFarmer);// Update advance amount       
	            paymentToFarmerRepository.save(paymentToFarmer);// Save the payment
	            return true;
	        }
	    } catch (Exception e) {       
	        e.printStackTrace(); 
	    }
	    return false;
	}	
	private void updateAdvanceAmount(PaymentToFarmer paymentToFarmer) {		
		Long farmerId = paymentToFarmer.getFarmer().getId();
		AdvanceToFarmer advanceToFarmer=advanceToFarmerService.getAdvanceToFarmerByFarmerId(farmerId);		
		if (advanceToFarmer != null && advanceToFarmer.getRemainingAmount() != null) {
		advanceToFarmer.setRemainingAmount(advanceToFarmer.getRemainingAmount()-paymentToFarmer.getAdvance_deduction());
		paymentToFarmer.setAdvance_deduction(paymentToFarmer.getAdvance_deduction());
		}
	}
	private void updateFeedRemainingAmount(PaymentToFarmer paymentToFarmer) {
	    Long farmerId = paymentToFarmer.getFarmer().getId();
	    List<FeedToFarmer> feedToFarmerList = feedToFarmerRepository.findAllByFarmerId(farmerId);
	    if (!feedToFarmerList.isEmpty()) {
	        for (FeedToFarmer feedToFarmer : feedToFarmerList) {
	    	if(feedToFarmer.getRemainingAmount() > paymentToFarmer.getFeed_deduction()) {
	        		AdvanceToFarmer advanceToFarmer=advanceToFarmerService.getAdvanceToFarmerByFarmerId(farmerId);	        		
	        		if (advanceToFarmer != null && advanceToFarmer.getRemainingAmount() != null) {
	        			advanceToFarmer.setRemainingAmount(advanceToFarmer.getRemainingAmount()+(feedToFarmer.getRemainingAmount() - paymentToFarmer.getFeed_deduction()));
	        			feedToFarmer.setRemainingAmount(0.0f);
	        			feedToFarmerRepository.save(feedToFarmer);
	        			return ;
	        		}     			
		          }
	        	float a = (feedToFarmer.getRemainingAmount() - paymentToFarmer.getFeed_deduction());
	            feedToFarmer.setRemainingAmount( a);	  
	            feedToFarmerRepository.save(feedToFarmer);// Save the updated FeedToFarmer entity
	        }
	    } else {
	        
	    }    
	}
	@Override
	public List<PaymentToFarmerResponseDto> getAllPaymentList(int branchId) {
		
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if (branchOptional.isPresent()) {
			
			List<PaymentToFarmer> list=paymentToFarmerRepository.findAllByBranch(branchOptional.get());
			return paymentTofarmerMapper.toList(list);
		}
		return null;
	}
	@Override
	public List<PaymentToFarmerResponseDto> getPaymentListBetweenFromDateAndToDate(LocalDate fromDate, LocalDate toDate,
			String milkType, int branchId) {
		
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if (branchOptional.isPresent()) {
			
			List<PaymentToFarmer> list=paymentToFarmerRepository.findAllByBranchAndDateBetweenFromDateAndToDate(branchOptional.get(),fromDate,toDate);
			return paymentTofarmerMapper.toList(list);
		}
		
		return null;
	}

	}
