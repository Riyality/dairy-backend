package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;

import com.dairy.mapper.feedcompany.FeedCompanyMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.FeedcompanyRepository;
import com.dairy.service.FeedCompanyService;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class FeedcompanyServiceImpl implements FeedCompanyService {

	@Autowired
	private FeedcompanyRepository feedComponyRepository;

	@Autowired
	private FeedCompanyMapper feedCompanyMapper;

	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public boolean addFeedCompany(FeedCompanyRequestDto dto) {
		try {
			FeedCompany feedCompany = feedCompanyMapper.toEntity(dto);
			
			Optional<Branch> branchopt = branchRepository.findById(dto.getBranchId());
			if (branchopt.isPresent())
				feedCompany.setBranch(branchopt.get());

			feedComponyRepository.save(feedCompany);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;

	}

	@Override
	public FeedCompanyResponseDto findById(Long id , int branchId) {
		Optional <Branch> branchOptional = branchRepository.findById(branchId);

		Optional<FeedCompany> opt = feedComponyRepository.findByIdAndBranch(id ,branchOptional.get());
		if (opt.isPresent()) {
			FeedCompany feedCompany = opt.get();
			return feedCompanyMapper.toFeedCompanyResponce(feedCompany);
		}
		return null;
	}

	@Override
	public List<FeedCompanyResponseDto> findAll(int branchId) {
		Optional <Branch> branchOptional = branchRepository.findById(branchId);
		
		if(branchOptional.isPresent()) {
			List<FeedCompany> feedcompany = feedComponyRepository.findByBranch( branchOptional.get() );
			return feedCompanyMapper.toList(feedcompany);
		}
		return null;
	}

	@Override
	public boolean updateFeedCompany(FeedCompanyRequestDto requestDto) {
		try{
		FeedCompany feedCompany = feedCompanyMapper.toEntity(requestDto);
		
		Optional<Branch> branchopt = branchRepository.findById(requestDto.getBranchId());
		if (branchopt.isPresent())
			feedCompany.setBranch(branchopt.get());

		feedComponyRepository.save(feedCompany);
		return true;

	} catch (Exception e) {
		log.error(e.getMessage(), e);
	}
	return false;
	}

	@Override
	public FeedCompanyRequestDto saveAllFeedCompanyList(List<FeedCompanyRequestDto> dtoList) {
		try {
			feedComponyRepository.saveAll(feedCompanyMapper.listToentity(dtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}