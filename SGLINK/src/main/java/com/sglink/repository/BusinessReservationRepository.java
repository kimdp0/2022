package com.sglink.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.entity.BusinessReservation;

public interface BusinessReservationRepository extends JpaRepository<BusinessReservation, Long> {

	static String updateBusinessReservationProcess = "update business_Reservation set process = :process where id=:id";

	@Transactional
	@Modifying
	@Query(value = updateBusinessReservationProcess, nativeQuery = true)
	void updateBusinessReservationProcess(@Param("id") Long id, @Param("process") String busiProcess);

	Page<BusinessReservation> findByBusiRegisterId(Pageable pageable, String userId);
}
