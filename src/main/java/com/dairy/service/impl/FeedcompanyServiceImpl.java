package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dairy.dto.feedcompany.FeedCompanyRequestDto;
import com.dairy.dto.feedcompany.FeedCompanyResponseDto;
import com.dairy.entity.FeedCompany;

import com.dairy.mapper.feedcompany.FeedCompanyMapper;
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

	@Override
	public boolean addFeedCompany(FeedCompanyRequestDto dto) {
		try {
			FeedCompany feedCompany = feedCompanyMapper.toEntity(dto);
			feedComponyRepository.save(feedCompany);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;

	}

	@Override
	public FeedCompanyResponseDto findById(Long id) {

		Optional<FeedCompany> opt = feedComponyRepository.findById(id);
		if (opt.isPresent()) {
			FeedCompany feedCompany = opt.get();
			return feedCompanyMapper.toFeedCompanyResponce(feedCompany);
		}
		return null;
	}

	@Override
	public List<FeedCompanyResponseDto> findAll() {
		List<FeedCompany> feedcompany = feedComponyRepository.findAll();
		return feedCompanyMapper.toList(feedcompany);
	}

}