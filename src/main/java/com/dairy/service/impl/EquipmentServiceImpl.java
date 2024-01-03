package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.entity.Equipment;
import com.dairy.mapper.equipment.EquipmentMapper;
import com.dairy.repository.EquipmentRepository;
import com.dairy.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	EquipmentRepository equipmentRepository;

	@Autowired
	EquipmentMapper equipmentMapper;

	@Override
	public List<EquipmentResponseDto> getAllEquipments() {

		List<Equipment> equipments = equipmentRepository.findAll();
		return equipmentMapper.toList(equipments);

	}

	@Override
	public boolean createEquipment(EquipmentRequestDto equipmentRequestDto) {
		try {
			Equipment equipment = equipmentMapper.toEntity(equipmentRequestDto);
			equipmentRepository.save(equipment);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public EquipmentResponseDto findById(long id) {
		Optional<Equipment> opt = equipmentRepository.findById(id);
		if (opt.isPresent())
			return equipmentMapper.toEquipmentResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean updateEquipment(EquipmentRequestDto equipmentRequestDto) {
		try {
			Equipment equipment = equipmentMapper.toEntity(equipmentRequestDto);
			equipmentRepository.save(equipment);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
