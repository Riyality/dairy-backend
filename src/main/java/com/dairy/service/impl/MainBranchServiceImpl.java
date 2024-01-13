package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.mainBranch.MainBranchRequestDto;
import com.dairy.dto.mainBranch.MainBranchResponseDto;
import com.dairy.entity.MainBranch;
import com.dairy.mapper.mainBranch.MainBranchMapper;
import com.dairy.repository.MainBranchRepository;
import com.dairy.service.MainBranchService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainBranchServiceImpl implements MainBranchService {
	@Autowired
	MainBranchRepository mainBranchRepository;

	@Autowired
	MainBranchMapper mainBranchMapper;

	@Override
	public boolean addMainBranch(MainBranchRequestDto requestDto) {
		try {
			MainBranch mainBranch = mainBranchMapper.toEntity(requestDto);
			mainBranchRepository.save(mainBranch);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<MainBranchResponseDto> getAllMainBranch() {

		List<MainBranch> mainBranch = mainBranchRepository.findAll();
		return mainBranchMapper.toList(mainBranch);
	}

	@Override
	public MainBranchResponseDto findByIdMainBranch(long id) {
		Optional<MainBranch> opt = mainBranchRepository.findById(id);
		if (opt.isPresent())
			return mainBranchMapper.toMainBranchResponseDto(opt.get());

		return null;
	}

	@Override
	public boolean updateMainBranch(MainBranchRequestDto requestDto) {

		try {
			MainBranch mainBranch = mainBranchMapper.toEntity(requestDto);
			mainBranchRepository.save(mainBranch);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
