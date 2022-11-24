package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String>{

	Equipment findOneByEquiId(String equiId);
}