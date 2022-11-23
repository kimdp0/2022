package com.sglink.equipment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.Equipment;
import com.sglink.equipment.dto.EquipmentRequestDto;
import com.sglink.repository.EquipmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentService {
	private final EquipmentRepository equipmentRepository;
	
	public Equipment findByEquiId(String equiId) {
		return equipmentRepository.findOneByEquiId(equiId);
	}
	

	@Transactional
	public String save(EquipmentRequestDto equipmentRequestDto) {
		return equipmentRepository.save(equipmentRequestDto.toEntity()).getEquiId();
	}
	
}
