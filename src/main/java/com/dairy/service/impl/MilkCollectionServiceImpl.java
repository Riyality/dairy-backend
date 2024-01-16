package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.MilkCollection;
import com.dairy.mapper.branch.BranchMapper;
import com.dairy.mapper.milkCollection.MilkCollectionMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.MilkCollectionRepository;
import com.dairy.service.MilkCollectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MilkCollectionServiceImpl implements MilkCollectionService {
	
	@Autowired
	private MilkCollectionMapper milkCollectionMapper;
	
	@Autowired
	private MilkCollectionRepository milkCollectionRepository;

	@Override
	public List<MilkCollectionResponseDto> getAllMilkCollectionData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMilkCollectionData(MilkCollectionRequestDto milkCollectionRequestDto) {
		try {
			
			MilkCollection milkCollection = milkCollectionMapper.toEntity( milkCollectionRequestDto);
			MilkCollection addedMilkCollection = milkCollectionRepository.save( milkCollection );

			return true;
		} catch ( Exception e ) {
			log.error( e.getMessage(), e );
		}
		return false;
	}

}