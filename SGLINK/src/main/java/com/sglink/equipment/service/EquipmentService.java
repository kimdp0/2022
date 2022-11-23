package com.sglink.equipment.service;

import org.springframework.stereotype.Service;

import com.sglink.repository.EquipmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipmentService {
	private final EquipmentRepository equipmentRepository;
	
	

}
