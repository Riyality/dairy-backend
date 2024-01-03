package com.dairy.mapper.equipment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.entity.Equipment;

@Component
public class EquipmentMapper {
	public Equipment toEntity(EquipmentRequestDto equipmentRequestDto ) {
		if ( equipmentRequestDto == null ) {
			return null;
		}

		 Equipment  equipment = new  Equipment();
		 equipment.setId( equipmentRequestDto.getId() );
		 equipment.setName( equipmentRequestDto.getName() );
		 equipment.setDateOfPurchase( equipmentRequestDto.getDateOfPurchase() );
		 equipment.setQuantity( equipmentRequestDto.getQuantity() );
		 equipment.setPrice( equipmentRequestDto.getPrice() );
		 equipment.setTotalAmount( equipmentRequestDto.getTotalAmount() );

		return equipment;
	}

	public EquipmentResponseDto toEquipmentResponseDto( Equipment equipment ) {
		if ( equipment == null ) {
			return null;
		}

		EquipmentResponseDto responseDto = new EquipmentResponseDto();
		responseDto.setId( equipment.getId() );
		responseDto.setName( equipment.getName() );
		responseDto.setDateOfPurchase( equipment.getDateOfPurchase() );
		responseDto.setQuantity( equipment.getQuantity() );
		responseDto.setPrice( equipment.getPrice() );
		responseDto.setTotalAmount( equipment.getTotalAmount() );

		return responseDto;
	}

	public List<EquipmentResponseDto> toList( List<Equipment> list ) {
		List<EquipmentResponseDto> dtos = new ArrayList<>();
		for ( Equipment entity : list ) {
			dtos.add( toEquipmentResponseDto( entity ) );
		}
		return dtos;

	}

}
