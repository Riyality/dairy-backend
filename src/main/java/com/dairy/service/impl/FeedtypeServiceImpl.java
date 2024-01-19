package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.feedtype.FeedTypeRequestDto;
import com.dairy.dto.feedtype.FeedTypeResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedType;
import com.dairy.mapper.feedtype.FeedTypeMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FeedTypeRepository;
import com.dairy.repository.FeedcompanyRepository;
import com.dairy.service.FeedTypeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class FeedtypeServiceImpl implements FeedTypeService {

	@Autowired
	FeedTypeRepository feedTypeRepository;

	@Autowired
	FeedTypeMapper feedTypeMapper;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private FeedcompanyRepository feedCompanyRepository;
	
	@Autowired
	private BranchRepository  branchRepository;

	@Override
	public boolean addFeed(FeedTypeRequestDto dto) {
		try {

			FeedType feedType = feedTypeMapper.toEntity(dto);
			
			Optional<FeedCompany> companyOpt = feedCompanyRepository.findById(dto.getFeedCompanyId());
			if (companyOpt.isPresent())
				feedType.setFeedcompany(companyOpt.get());
			

			Optional<Branch> branchOpt = branchRepository.findById( dto.getBranchId() );
			if ( branchOpt.isPresent() )
				feedType.setBranch( branchOpt.get() );
			
			feedTypeRepository.save(feedType);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public FeedTypeResponseDto findById(Long id) {

		Optional<FeedType> opt = feedTypeRepository.findById(id);
		if (opt.isPresent()) {
			FeedType feedType = opt.get();

			return feedTypeMapper.toFeedTypeResponse(feedType);
		}
		return null;
	}

	@Override
	public List<FeedTypeResponseDto> getAllFeedTypes() {
		List<FeedType> feedType = feedTypeRepository.findAll();

		return feedTypeMapper.toList(feedType);
	}

	@Override
	public List<FeedTypeResponseDto> getFeedTypeByFeedCompanyId(int id, int branchId) {
		List<FeedType> feedType = null;
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if (branchOptional.isPresent()) {
			 feedType = feedTypeRepository.findByIdAndBranch(id, branchId);
		}

		return feedTypeMapper.toList(feedType);
	}

	@Override
	public boolean updateFeed(FeedTypeRequestDto dto) {
		try {

			FeedType feedType = feedTypeMapper.toEntity(dto);
			
			Optional<FeedCompany> companyOpt = feedCompanyRepository.findById(dto.getFeedCompanyId());
			if (companyOpt.isPresent())
				feedType.setFeedcompany(companyOpt.get());
			

			Optional<Branch> branchOpt = branchRepository.findById( dto.getBranchId() );
			if ( branchOpt.isPresent() )
				feedType.setBranch( branchOpt.get() );
			
			feedTypeRepository.save(feedType);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
