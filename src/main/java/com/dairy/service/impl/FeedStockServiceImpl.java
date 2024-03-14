
package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.feedDetails.FeedDetailsRequestDto;
import com.dairy.dto.feedDetails.FeedDetailsResponseDto;
import com.dairy.dto.feedStock.FeedStockRequestDto;
import com.dairy.dto.feedStock.FeedStockResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedDetails;
import com.dairy.entity.FeedStock;
import com.dairy.entity.FeedType;
import com.dairy.entity.Supplier;
import com.dairy.mapper.feedDetails.FeedDetailsMapper;
import com.dairy.mapper.feedStock.FeedStockMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FeedDetailsRepository;
import com.dairy.repository.FeedStockRepository;
import com.dairy.repository.FeedTypeRepository;
import com.dairy.repository.FeedcompanyRepository;
import com.dairy.repository.SupplierRepository;
import com.dairy.service.FeedStockService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FeedStockServiceImpl implements FeedStockService {

	@Autowired
	FeedStockMapper feedStockMapper;

	@Autowired
	FeedStockRepository feedStockRepository;
	@Autowired
	FeedDetailsRepository feeddetailsRepository;

	@Autowired
	FeedcompanyRepository feedcompanyRepository;

	@Autowired
	FeedTypeRepository feedTypeRepository;

	@Autowired
	FeedDetailsMapper feedDetailsMapper;
	
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	BranchRepository branchRepository;

	@Override
	public boolean addFeedStock(FeedStockRequestDto feedStockRequestDto) {
		try {
			FeedStock feedStock = feedStockMapper.toEntity(feedStockRequestDto);

			Optional<Branch> branchopt = branchRepository.findById(feedStockRequestDto.getBranchId());
			if (branchopt.isPresent())
				feedStock.setBranch(branchopt.get());

			Optional<Supplier> suppopt = supplierRepository.findById(feedStockRequestDto.getSupplierId());
			if (suppopt.isPresent())
				feedStock.setSupplier(suppopt.get());

			Optional<FeedCompany> feedcompopt = feedcompanyRepository.findById(feedStockRequestDto.getFeedCompanyId());
			if (feedcompopt.isPresent())
				feedStock.setFeedCompany(feedcompopt.get());

			Optional<FeedType> feedtypeopt = feedTypeRepository.findById(feedStockRequestDto.getFeedTypeId());
			if (feedtypeopt.isPresent())
				feedStock.setFeedType(feedtypeopt.get());

			feedStockRepository.save(feedStock);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<FeedStockResponseDto> getAllFeed(int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
			List<FeedStock> feedStock = feedStockRepository.findByBranch( branchOptional.get() );
			return feedStockMapper.toList(feedStock);
		}
		return null;
	}

	@Override
	public FeedStockResponseDto findById(int id ,int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if(branchOptional.isPresent()) {
			Optional<FeedStock> opt = feedStockRepository.findByIdAndBranch(id ,branchOptional.get());
			return feedStockMapper.toFeedStockResponseDto(opt.get());
		}
		return null;
	}

	@Override
	public boolean updateFeedStock(FeedStockRequestDto feedStockRequestDto) {

		try {
			FeedStock feedStock = feedStockMapper.toEntity(feedStockRequestDto);

			Optional<Branch> branchopt = branchRepository.findById(feedStockRequestDto.getBranchId());
			if (branchopt.isPresent())
				feedStock.setBranch(branchopt.get());

			Optional<Supplier> suppopt = supplierRepository.findById(feedStockRequestDto.getSupplierId());
			if (suppopt.isPresent())
				feedStock.setSupplier(suppopt.get());

			Optional<FeedCompany> feedcompopt = feedcompanyRepository.findById(feedStockRequestDto.getFeedCompanyId());
			if (feedcompopt.isPresent())
				feedStock.setFeedCompany(feedcompopt.get());

			Optional<FeedType> feedtypeopt = feedTypeRepository.findById(feedStockRequestDto.getFeedTypeId());
			if (feedtypeopt.isPresent())
				feedStock.setFeedType(feedtypeopt.get());

			feedStockRepository.save(feedStock);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
  
  
	@Override
	public int getTotalQuantityByBranch(int branchId) {
		return feeddetailsRepository.getTotalQuantityByBranch(branchId);
	}

	@Transactional
	@Override
	public boolean addFeedStock(List<FeedStockRequestDto> feedStockRequestDtoList) {
	    try {
	    	
	    	for (FeedStockRequestDto feedStockRequestDto : feedStockRequestDtoList) {
	            FeedStock feedStock = feedStockMapper.toEntity(feedStockRequestDto);

	            Optional<Branch> branchopt = branchRepository.findById(feedStockRequestDto.getBranchId());
	            branchopt.ifPresent(feedStock::setBranch);

	            Optional<Supplier> suppopt = supplierRepository.findById(feedStockRequestDto.getSupplierId());
	            suppopt.ifPresent(feedStock::setSupplier);

	            Optional<FeedCompany> feedcompopt = feedcompanyRepository.findById(feedStockRequestDto.getFeedCompanyId());
	            feedcompopt.ifPresent(feedStock::setFeedCompany);

	            Optional<FeedType> feedtypeopt = feedTypeRepository.findById(feedStockRequestDto.getFeedTypeId());
	            feedtypeopt.ifPresent(feedStock::setFeedType);
	            
	            // Check if FeedTypeId and FeedCompanyId already exist in FeedDetails
	            Optional<FeedDetails> existingFeedDetailsOpt = feeddetailsRepository.findByFeedCompanyIdAndFeedTypeId(
	                feedStockRequestDto.getFeedCompanyId(), feedStockRequestDto.getFeedTypeId());

	            FeedDetails feedDetails;
	            if (existingFeedDetailsOpt.isPresent()) {
	                // If exists, update the quantity
	                feedDetails = existingFeedDetailsOpt.get();
	                feedDetails.setQuantity(feedDetails.getQuantity() + feedStockRequestDto.getQuantity());
	            } else {
	                // If not exists, create a new record
	            	FeedDetailsRequestDto dto = new FeedDetailsRequestDto();
	                dto.setFeedCompanyId(feedStockRequestDto.getFeedCompanyId());
	                dto.setFeedTypeId(feedStockRequestDto.getFeedTypeId());
	                dto.setQuantity(feedStockRequestDto.getQuantity());
	                dto.setBranchId(feedStockRequestDto.getBranchId());
	                feedDetails = feedDetailsMapper.toEntity(dto);
	            }

	            feeddetailsRepository.save(feedDetails);
	            feedStockRepository.save(feedStock);
	        }
	        return true;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        return false;
	    }
	}

	@Override
	public long getFeedQuantityByFeedTypeFeedCompanyAndBranch(long feedTypeId, long feedCompanyId, int branchId) {
		
		
		return feeddetailsRepository.getFeedQuantityByFeedTypeFeedCompanyAndBranch(feedTypeId,feedCompanyId,branchId);
	}

	@Override
	public List<FeedDetailsResponseDto> getAllFeedDetails(int branchId) {
		
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
			List<FeedDetails> feedDetails = feeddetailsRepository.findByBranch( branchOptional.get() );
			return feedDetailsMapper.toList(feedDetails);
		}
		
		return null;
	}



}

