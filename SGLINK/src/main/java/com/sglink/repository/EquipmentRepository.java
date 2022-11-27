package com.sglink.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {

	Equipment findOneByEquiId(String equiId);

	static String updateEquipmentProcess = "update equipment set process = :equipment where equi_id=:equiId";

	@Transactional
	@Modifying
	@Query(value = updateEquipmentProcess, nativeQuery = true)
	void updateEquipmentProcess(@Param("equiId") String equiId, @Param("equipment") String equipment);
}