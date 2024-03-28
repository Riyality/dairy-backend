package com.dairy.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.feedToFarmer.FeedToFarmerRequestDto;
import com.dairy.dto.feedToFarmer.FeedToFarmerResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedDetails;
import com.dairy.entity.FeedStock;
import com.dairy.entity.FeedToFarmer;
import com.dairy.entity.FeedType;
import com.dairy.mapper.feedToFarmer.FeedToFarmerMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
import com.dairy.repository.FeedDetailsRepository;
import com.dairy.repository.FeedStockRepository;
import com.dairy.repository.FeedToFarmerRepository;
import com.dairy.repository.FeedTypeRepository;
import com.dairy.repository.FeedcompanyRepository;
import com.dairy.service.FeedToFarmerService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FeedToFarmerServiceImpl implements FeedToFarmerService {
	
	@Autowired
	FeedToFarmerMapper feedToFarmerMapper;
	
	@Autowired
	FeedToFarmerRepository  feedToFarmerRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	FarmerRepository farmerRepository;
	
	@Autowired
	FeedTypeRepository  FeedTypeRepository;
	
	@Autowired
	FeedcompanyRepository feedcompanyRepository;

	@Autowired
	FeedStockRepository feedStockRepository;
	@Autowired
	FeedDetailsRepository feeddetailsRepository;

	@Override
	public boolean addFeedToFarmer(FeedToFarmerRequestDto feedToFarmerReqDto) {
		try {
			FeedToFarmer feedToFarmer=feedToFarmerMapper.toEntity(feedToFarmerReqDto);
			
			Optional<Branch> branchOpt = branchRepository.findById( feedToFarmerReqDto.getBranchId() );
			if ( branchOpt.isPresent() )
				feedToFarmer.setBranch( branchOpt.get() );
			
			Optional<Farmer> farmerOpt=farmerRepository.findById(feedToFarmerReqDto.getFarmerId());
			 if(farmerOpt.isPresent())
				 feedToFarmer.setFarmer(farmerOpt.get());
			Optional<FeedType> feedTypeOpt=FeedTypeRepository.findById(feedToFarmerReqDto.getFeedTypeId());
			  if(feedTypeOpt.isPresent())
				  feedToFarmer.setFeedType(feedTypeOpt.get());
			  
			Optional<FeedCompany>  feedCompanyOpt=feedcompanyRepository.findById(feedToFarmerReqDto.getFeedCompanyId());
			if(feedCompanyOpt.isPresent())
				feedToFarmer.setFeedCompany(feedCompanyOpt.get());
				if( updateFeedStockQuantity(feedToFarmerReqDto)) {
					feedToFarmerRepository.save(feedToFarmer);
					return true;
				}
				else {
					return false;
				}
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return false;
	}

	
	 private boolean updateFeedStockQuantity(FeedToFarmerRequestDto feedToFarmerReqDto) {
	        try {
	        	Optional<FeedType> feedTypeOpt=FeedTypeRepository.findById(feedToFarmerReqDto.getFeedTypeId());
	        	Optional<FeedCompany>  feedCompanyOpt=feedcompanyRepository.findById(feedToFarmerReqDto.getFeedCompanyId());
	        	Optional<Branch> branchOpt = branchRepository.findById( feedToFarmerReqDto.getBranchId() );
	        	Optional<FeedDetails> feeddetailsOpt = feeddetailsRepository.findByFeedTypeAndFeedCompanyAndBranch(
	        			feedTypeOpt, feedCompanyOpt,branchOpt);
	        	if (feeddetailsOpt.isPresent()) {
	        		FeedDetails feedDetails = feeddetailsOpt.get();
	                int consumedQuantity = feedToFarmerReqDto.getQuantity(); 
	                int currentQuantity = (int) feedDetails.getQuantity();
	                if (consumedQuantity <= currentQuantity) {
	                    int updatedQuantity = currentQuantity - consumedQuantity;
	                    feedDetails.setQuantity(updatedQuantity);// Update the Feed quantity
	                    feeddetailsRepository.save(feedDetails);
	                    
	                    if (updatedQuantity < 5) {
	                    	System.out.println("Available Feed Quantity is Below 5");
	                        log.warn("Feed quantity for Feed Type ID {} and Feed Company ID {} is running low.",
	                                feedToFarmerReqDto.getFeedTypeId(), feedToFarmerReqDto.getFeedCompanyId());
	                    }
	                    return true;
	                } else {
	                	System.out.println("Requested quantity exceeds available quantity");
	                	 log.warn("Requested quantity exceeds available quantity for Feed Type ID {} and Feed Company ID {}",
	                            feedToFarmerReqDto.getFeedTypeId(), feedToFarmerReqDto.getFeedCompanyId());
	                }
	            } else {
	            	System.out.println("Stock not available");
	                log.error("Feed stock record not found for Feed Type ID {} and Feed Company ID {}",
	                        feedToFarmerReqDto.getFeedTypeId(), feedToFarmerReqDto.getFeedCompanyId());
	            }
	        } catch (Exception e) {
	            log.error("Error updating feed stock quantity: {}", e.getMessage(), e);
	        }
			return false;
	    }


	@Override
	public List<FeedToFarmerResponseDto> getAllFeedToFarmer(int branchId) {
		
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
		List<FeedToFarmer> feedToFarmer = feedToFarmerRepository.findByBranch(branchOptional.get());
		return feedToFarmerMapper.toList(feedToFarmer);
		
		}
		return null;
	}
	


	@Override
	public FeedToFarmerResponseDto findByIdFeedTOFarmer(Long id) {
		
		Optional<FeedToFarmer> opt = feedToFarmerRepository.findById(id);
		if (opt.isPresent())
			return feedToFarmerMapper.toFeedToFarmerResponseDto(opt.get());
		return null;
	}


	@Override
	public boolean updateFeedToFarmer(FeedToFarmerRequestDto feedToFarmerRequestDto) {
		try {
			FeedToFarmer feedToFarmer=feedToFarmerMapper.toEntity(feedToFarmerRequestDto);
			
			Optional<Branch> branchOpt = branchRepository.findById( feedToFarmerRequestDto.getBranchId() );
			if ( branchOpt.isPresent() )
				feedToFarmer.setBranch( branchOpt.get() );
			
			Optional<Farmer> farmerOpt=farmerRepository.findById(feedToFarmerRequestDto.getFarmerId());
			 if(farmerOpt.isPresent())
				 feedToFarmer.setFarmer(farmerOpt.get());
			Optional<FeedType> feedTypeOpt=FeedTypeRepository.findById(feedToFarmerRequestDto.getFeedTypeId());
			  if(feedTypeOpt.isPresent())
				  feedToFarmer.setFeedType(feedTypeOpt.get());
			  
			Optional<FeedCompany>  feedCompanyOpt=feedcompanyRepository.findById(feedToFarmerRequestDto.getFeedCompanyId());
			if(feedCompanyOpt.isPresent())
				feedToFarmer.setFeedCompany(feedCompanyOpt.get());
			
			feedToFarmerRepository.save(feedToFarmer);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return false;
	
	}


	@Override
	public Double findTotalOfRemainingAmountByFarmerIdAndBranchId(long farmerId, int branchId,LocalDate fromDate, LocalDate toDate) {

		return feedToFarmerRepository.findTotalOfRemainingAmountByFarmerIdAndBranchId(farmerId,branchId,fromDate,toDate);
	}


	@Override
	public FeedToFarmer findByFarmerId(Long farmerId) {
		
		return feedToFarmerRepository.findByFarmerId(farmerId);
	}
	

    public List<FeedToFarmer> getFarmersByFarmerId(Long farmerId) {
        return feedToFarmerRepository.findAllByFarmerId(farmerId);
    }


	@Override
	public List<FeedToFarmerResponseDto> getRecordsDatewise(LocalDate fromDate, LocalDate toDate,int branchId,String flag) {
     
       if ("all".equals(flag)) {
		List<FeedToFarmer> list=feedToFarmerRepository.findByDateOfPurchaseBetweenAndBranchId(fromDate,toDate,branchId);
		return feedToFarmerMapper.toList(list);
       }
       if( ! isNumeric(flag)) {
    	   Long feedCompanyId = (long) Integer.parseInt(flag.substring(0, 1));
    	   System.out.println(feedCompanyId);
    	   Optional<FeedCompany> feedCompanyOpt = feedcompanyRepository.findById(feedCompanyId);
    	    if (feedCompanyOpt.isPresent()) {
    	        List<FeedToFarmer> list = feedToFarmerRepository.findByDateOfPurchaseBetweenAndBranchIdAndFeedCompany(
    	            fromDate, toDate, branchId, feedCompanyOpt);
    	        System.out.println(list);
    	        return feedToFarmerMapper.toList(list);
    	    } else {
    	        return Collections.emptyList(); // or throw an exception or handle accordingly
    	    }
    	    
  }
       long farmerId = Long.parseLong(flag);
       Optional<Farmer> farmer = farmerRepository.findById(farmerId);
       List<FeedToFarmer> list=feedToFarmerRepository.findByDateOfPurchaseBetweenAndBranchIdAndFarmer(fromDate,toDate,branchId,farmer);
		return feedToFarmerMapper.toList(list);
	}
	 private boolean isNumeric(String str) {
	        try {
	            Long.parseLong(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }


	


}
