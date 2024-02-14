package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.paymentToFarmer.PaymentToFarmerRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedToFarmer;
import com.dairy.entity.PaymentToFarmer;
import com.dairy.mapper.paymentToFarmer.PaymentToFarmerMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.repository.FeedToFarmerRepository;
import com.dairy.repository.PaymentToFarmerRepository;
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
	private FeedToFarmerRepository feedToFarmerRepository;
	
	
	@Autowired
	FeedToFarmerService feedToFarmerService;
	

	@Autowired
	private PaymentToFarmerMapper paymentToFarmerMapper;
	
	
	@Override
	public boolean addPayment(PaymentToFarmerRequestDto paymentToFarmerRequestDto) {
		
		PaymentToFarmer paymentToFarmer = paymentToFarmerMapper.toEntity(paymentToFarmerRequestDto);
	
		Optional<Branch> opt = branchRepository.findById(paymentToFarmerRequestDto.getBranch());
		Optional<Farmer> opt2 = farmerRepository.findById(paymentToFarmerRequestDto.getFarmer());
		if (opt.isPresent() && opt2.isPresent()) {
			paymentToFarmer.setBranch(opt.get());
			paymentToFarmer.setFarmer(opt2.get());
			
			//System.out.println("FEED "+paymentToFarmer.getFeed_deduction());
			//update remaining Amount in FeedToFarmer table
			 updateRemainingAmount(paymentToFarmer);
			
			paymentToFarmerRepository.save(paymentToFarmer);
		return true;
		}
	
		
		return false;
	}
	
	
	
	private void updateRemainingAmount(PaymentToFarmer paymentToFarmer) {
	    Long farmerId = paymentToFarmer.getFarmer().getId();

	    List<FeedToFarmer> feedToFarmerList = feedToFarmerRepository.findAllByFarmerId(farmerId);

	    
	 
	    if (!feedToFarmerList.isEmpty()) {
	        for (FeedToFarmer feedToFarmer : feedToFarmerList) {
	        	System.out.println("REMAIN:"+feedToFarmer.getRemainingAmount());
	            double remainingAmount = feedToFarmer.getRemainingAmount() - paymentToFarmer.getFeed_deduction();
	            feedToFarmer.setRemainingAmount((float) remainingAmount);
	            
	            feedToFarmerRepository.save(feedToFarmer);// Save the updated FeedToFarmer entity
	        }
	    } else {
	        // Handle the case where no FeedToFarmer entity is found for the given farmerId
	        // You might want to log a warning or take appropriate action
	    }
	    
	}
	
	
//	private void updateRemainingAmount(PaymentToFarmer paymentToFarmer) {
//	    Long farmerId = paymentToFarmer.getFarmer().getId();
//
//	    List<FeedToFarmer> feedToFarmerList = feedToFarmerRepository.findAllByFarmerId(farmerId);
//
//	    if (!feedToFarmerList.isEmpty()) {
//	        for (FeedToFarmer feedToFarmer : feedToFarmerList) {
//	            System.out.println("FarmerList:" + feedToFarmer);
//	            if (feedToFarmer.getRemainingAmount() < 0) {
//	                System.out.println("Less Than Zero");
//	            }
//	            double remainingAmount = feedToFarmer.getRemainingAmount() - paymentToFarmer.getFeed_deduction();
//	            feedToFarmer.setRemainingAmount((float) remainingAmount);
//
//	            // Save the updated FeedToFarmer entity
//	            feedToFarmerRepository.save(feedToFarmer);
//	        }
//	    } else {
//	        // Handle the case where no FeedToFarmer entity is found for the given farmerId
//	        // You might want to log a warning or take appropriate action
//	    }
//	}
	
	
	
	
	
	}
