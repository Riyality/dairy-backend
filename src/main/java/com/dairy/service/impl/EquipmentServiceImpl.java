package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Equipment;
import com.dairy.mapper.equipment.EquipmentMapper;
import com.dairy.repository.BranchRepository;
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
	
	@Autowired
	BranchRepository branchRepository;

	@Override
	public List<EquipmentResponseDto> getAllEquipments(int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		
		if(branchOptional.isPresent()) {
			List<Equipment> equipments = equipmentRepository.findByBranch( branchOptional.get() );
			return equipmentMapper.toList(equipments);
		}
		return null ;
	}

	@Override
	public boolean createEquipment(EquipmentRequestDto equipmentRequestDto) {
		try {
			Equipment equipment = equipmentMapper.toEntity(equipmentRequestDto);
			
			Optional<Branch> opt = branchRepository.findById(equipmentRequestDto.getBranchId());
			if (opt.isPresent())
				equipment.setBranch(opt.get());
			
			equipmentRepository.save(equipment);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public EquipmentResponseDto findById(long id ,int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		Optional<Equipment> opt = equipmentRepository.findByIdAndBranch(id ,branchOptional.get());
		if (opt.isPresent())
			return equipmentMapper.toEquipmentResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean updateEquipment(EquipmentRequestDto equipmentRequestDto) {
		try {
			Equipment equipment = equipmentMapper.toEntity(equipmentRequestDto);
			Optional<Branch> opt = branchRepository.findById(equipmentRequestDto.getBranchId());
			if (opt.isPresent())
				equipment.setBranch(opt.get());
			equipmentRepository.save(equipment);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
