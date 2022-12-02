package com.sglink.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.EquipmentReservation;

public interface EquipmentReservationRepository extends JpaRepository<EquipmentReservation, Long> {
		Page<EquipmentReservation> findByEquiRegisterId(Pageable pageable,String userId);
}
