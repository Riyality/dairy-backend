package com.dairy.service;

import java.util.List;

import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;

public interface FarmerService {

	boolean add( FarmerRequestDto dto );

	FarmerResponseDto findById( Long id );

	List<FarmerResponseDto> findAllActive( int id );

}
