package com.dairy.service;

import java.util.List;

import com.dairy.dto.dairyManger.DairyManagerRequestDto;
import com.dairy.dto.dairyManger.DairyManagerResponseDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesRequestDto;
import com.dairy.dto.dairyMangerUpdates.DairyMangerUpdatesResponseDto;

public interface DairyManagerService {

	boolean add(DairyManagerRequestDto dto);

	List<DairyManagerResponseDto> getAllDairy();

	DairyManagerResponseDto findById(Long id);

	boolean addUpdates(DairyMangerUpdatesRequestDto dto);

	List<DairyMangerUpdatesResponseDto> getAllDairyUpdates();


}
