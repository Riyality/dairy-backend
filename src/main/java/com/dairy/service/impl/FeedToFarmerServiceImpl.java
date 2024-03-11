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
import com.dairy.entity.FeedToFarmer;
import com.dairy.entity.FeedType;
import com.dairy.mapper.feedToFarmer.FeedToFarmerMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FarmerRepository;
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
			
			feedToFarmerRepository.save(feedToFarmer);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return false;
	}


	@Override
	public List<FeedToFarmerResponseDto> getAllFeedToFarmer() {
		List<FeedToFarmer> feedToFarmer = feedToFarmerRepository.findAll();
		return feedToFarmerMapper.toList(feedToFarmer);

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
       System.out.println(flag);
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
