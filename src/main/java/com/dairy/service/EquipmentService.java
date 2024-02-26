package com.dairy.service;

import java.util.List;

import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;

public interface EquipmentService {

	List<EquipmentResponseDto> getAllEquipments(int branchId);

	boolean createEquipment(EquipmentRequestDto equipmentRequestDto);

	EquipmentResponseDto findById(long id, int branchId);

	boolean updateEquipment(EquipmentRequestDto equipmentRequestDto);

}
