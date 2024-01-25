package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.dairyManger.DairyManagerRequestDto;
import com.dairy.dto.dairyManger.DairyManagerResponseDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesRequestDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesResponseDto;
import com.dairy.entity.DairyManger;
import com.dairy.entity.DairyMangerUpdate;
import com.dairy.mapper.dairyManger.DairyManagerMapper;
import com.dairy.mapper.dairyMangerUpdates.DairyMangerUpdatesMapper;
import com.dairy.repository.DairyManagerRepositry;
import com.dairy.repository.DairyMangerUpdatesRepository;
import com.dairy.service.DairyManagerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DairyManagerServiceImpl implements DairyManagerService {

	@Autowired
	private DairyManagerMapper dairyManagerMapper;

	@Autowired
	 private DairyManagerRepositry dairyManagerRepositry;
	
	@Autowired
	private DairyMangerUpdatesMapper dairyMangerUpdatesMapper;
	
	@Autowired
	private DairyMangerUpdatesRepository dairyMangerUpdatesRepository;

	@Override
	public boolean add(DairyManagerRequestDto dto) {
		try {
			DairyManger dairyManager = dairyManagerMapper.toEntity(dto);

			dairyManagerRepositry.save(dairyManager);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<DairyManagerResponseDto> getAllDairy() {
		List<DairyManger> dairyManager = dairyManagerRepositry.findAll();
		return dairyManagerMapper.toList(dairyManager);
	}

	@Override
	public DairyManagerResponseDto findById(Long id) {
		Optional<DairyManger> opt = dairyManagerRepositry.findById(id);
		if (opt.isPresent())
			return dairyManagerMapper.toDairyManagerResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean addUpdates(DairyMangerUpdatesRequestDto dto) {
		try {
			DairyMangerUpdate dairyMangerUpdates = dairyMangerUpdatesMapper.toEntity(dto);
			
			Optional<DairyManger> opt = dairyManagerRepositry.findById(dto.getDairyMangerId());
			if (opt.isPresent())
				dairyMangerUpdates.setDairyManger(opt.get());

			dairyMangerUpdatesRepository.save(dairyMangerUpdates);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public List<DairyMangerUpdatesResponseDto> getAllDairyUpdates() {
		List<DairyMangerUpdate> dairyMangerUpdate = dairyMangerUpdatesRepository.findAll();
		return dairyMangerUpdatesMapper.toList(dairyMangerUpdate);
	}

	

	

}
