package com.dairy.mapper.farmers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.entity.Farmer;
import com.dairy.mapper.bank.BankMapper;
import com.dairy.mapper.route.RouteMapper;

@Component
public class FarmerMapper {

	@Autowired
	private BankMapper bankMapper;
	
	@Autowired
	private RouteMapper routeMapper;

	public Farmer toEntity( FarmerRequestDto requestDto ) {
		Farmer farmer = new Farmer();
		farmer.setId( requestDto.getId() );
		farmer.setName( requestDto.getName() );
		farmer.setDateOfRegistration( requestDto.getDateOfRegistration() );
		farmer.setContact( requestDto.getContact() );
		farmer.setAddress( requestDto.getAddress() );
		farmer.setStatus("active");
		return farmer;
	}

	public FarmerResponseDto toResponseDto( Farmer farmer ) {
		FarmerResponseDto responseDto = new FarmerResponseDto();
		responseDto.setId( farmer.getId() );
		responseDto.setName( farmer.getName() );
		responseDto.setDateOfRegistration( farmer.getDateOfRegistration() );
		responseDto.setContact( farmer.getContact() );
		responseDto.setAddress( farmer.getAddress() );
		responseDto.setStatus( farmer.getStatus() );

		if ( farmer.getRoute() != null ) {
			responseDto.setRoute( routeMapper.toRouteResponseDto( farmer.getRoute() ) );
		}
		
		if ( farmer.getBank() != null ) {
			responseDto.setBank( bankMapper.toBankResponseDto( farmer.getBank() ) );
		}

		return responseDto;
	}

	public List<FarmerResponseDto> toList( List<Farmer> farmerList ) {
		return farmerList.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}
}
