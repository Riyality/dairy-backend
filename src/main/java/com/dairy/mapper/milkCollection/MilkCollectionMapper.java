package com.dairy.mapper.milkCollection;

import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.dto.milkCollection.MilkCollectionResponseDto;
import com.dairy.entity.Farmer;
import com.dairy.entity.MilkCollection;

@Component
public class MilkCollectionMapper {
	
	public MilkCollection toEntity( MilkCollectionRequestDto milkCollectionRequestDto ) {
		
		if ( milkCollectionRequestDto == null ) {
			return null;
		}

		MilkCollection milkCollection = new MilkCollection();
		milkCollection.setDateOfCollection(milkCollectionRequestDto.getDateOfMilkCollection());
		milkCollection.setShift(milkCollectionRequestDto.getMilkCollectionShift());
		milkCollection.setType(milkCollectionRequestDto.getAnimalType());
		milkCollection.setQuantity(milkCollectionRequestDto.getMilkQuantity());
		milkCollection.setFat(milkCollectionRequestDto.getMilkFat());
		milkCollection.setSnf(milkCollectionRequestDto.getMilkSNF());
		milkCollection.setRate(milkCollectionRequestDto.getMilkRate());
		milkCollection.setTotal_amount(milkCollectionRequestDto.getTotalMilkAmount());
		
		return milkCollection;
	}
  
	public MilkCollectionResponseDto toResponseDto( MilkCollection milkCollection ) {
		MilkCollectionResponseDto responseDto = new MilkCollectionResponseDto();
		responseDto.setFarmerId(milkCollection.getFarmer().getId());
		responseDto.setDateOfMilkCollection(milkCollection.getDateOfCollection());
		responseDto.setFarmerName(milkCollection.getFarmer().getName());
		responseDto.setAnimalType( milkCollection.getType());
		responseDto.setMilkFat( milkCollection.getFat() );
		responseDto.setMilkSNF( milkCollection.getSnf() );
		responseDto.setMilkRate(milkCollection.getRate());
		//responseDto.setRemark("New");
		responseDto.setMilkQuantity(milkCollection.getQuantity());
		responseDto.setTotalMilkAmount(milkCollection.getTotal_amount());
		

		return responseDto;
	}

	public List<MilkCollectionResponseDto> toList1( List<MilkCollection> list ) {
		return list.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}


	public List<MilkCollectionResponseDto> toList(List<MilkCollection> list) {
		
        List<MilkCollectionResponseDto> dtoList = new ArrayList<>();
        for (MilkCollection milkCollection : list) {
            dtoList.add(toMilkCollectionResponseDto(milkCollection));
        }
        return dtoList;
    }

    public MilkCollectionResponseDto toMilkCollectionResponseDto(MilkCollection milkCollection) {
    	
        MilkCollectionResponseDto responseDto = new MilkCollectionResponseDto();
        
        responseDto.setFarmerId(milkCollection.getFarmer().getId());
        responseDto.setFarmerName(milkCollection.getFarmer().getName());
        responseDto.setAnimalType(milkCollection.getType());
        responseDto.setMilkQuantity(milkCollection.getQuantity());
        responseDto.setMilkFat(milkCollection.getFat());
        responseDto.setMilkSNF(milkCollection.getSnf());
        responseDto.setMilkRate(milkCollection.getRate());
        responseDto.setTotalMilkAmount(milkCollection.getTotal_amount());
        responseDto.setRemark(""); // You can set this based on your logic or leave it empty
        responseDto.setDateOfMilkCollection(milkCollection.getDateOfCollection());

        return responseDto;
    }
	
}
