package com.dairy.mapper.milkCollection;

import org.springframework.stereotype.Component;

import com.dairy.dto.milkCollection.MilkCollectionRequestDto;
import com.dairy.entity.Farmer;
import com.dairy.entity.MilkCollection;

@Component
public class MilkCollectionMapper {
	
	public MilkCollection toEntity( MilkCollectionRequestDto milkCollectionRequestDto ) {
		if ( milkCollectionRequestDto == null ) {
			return null;
		}
		
		Farmer farmer = new Farmer();		
		MilkCollection milkCollection = new MilkCollection();
		milkCollection.setDate_of_collection(milkCollectionRequestDto.getDateOfMilkCollection());
		milkCollection.setShift(milkCollectionRequestDto.getMilkCollectionShift());
		milkCollection.setType(milkCollectionRequestDto.getAnimalType());
		milkCollection.setQuantity(milkCollectionRequestDto.getMilkQuantity());
		milkCollection.setFat(milkCollectionRequestDto.getMilkFat());
		milkCollection.setSnf(milkCollectionRequestDto.getMilkSNF());
		milkCollection.setRate(milkCollectionRequestDto.getMilkRate());
		milkCollection.setTotal_amount(milkCollectionRequestDto.getTotalMilkAmount());

		return milkCollection;
	}
}
