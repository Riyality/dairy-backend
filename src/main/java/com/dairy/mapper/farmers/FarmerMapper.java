package com.dairy.mapper.farmers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.entity.Farmer;
import com.dairy.mapper.bank.BankMapper;

@Component
public class FarmerMapper {

	@Autowired
	private BankMapper bankMapper;

	public Farmer toEntity( FarmerRequestDto requestDto ) {
		Farmer farmer = new Farmer();
		farmer.setId( requestDto.getId() );
		farmer.setName( requestDto.getName() );
		farmer.setDateOfRegistration( requestDto.getDateOfRegistration() );
		farmer.setContact( requestDto.getContact() );
		farmer.setRoute( requestDto.getRoute() );
		farmer.setAddress( requestDto.getAddress() );
		return farmer;
	}

	public FarmerResponseDto toResponseDto( Farmer farmer ) {
		FarmerResponseDto responseDto = new FarmerResponseDto();
		responseDto.setId( farmer.getId() );
		responseDto.setName( farmer.getName() );
		responseDto.setDateOfRegistration( farmer.getDateOfRegistration() );
		responseDto.setContact( farmer.getContact() );
		responseDto.setRoute( farmer.getRoute() );
		responseDto.setAddress( farmer.getAddress() );

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
