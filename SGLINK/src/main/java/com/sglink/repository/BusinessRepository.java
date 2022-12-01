package com.sglink.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.common.constant.Process;
import com.sglink.entity.Business;
import com.sglink.entity.Equipment;

public interface BusinessRepository extends JpaRepository<Business, String> {

	Business findOneByBusiId(String busiId);
	
	static String updateBusinessProcess = "update business set process = :business where busi_id=:busiId";

	@Transactional
	@Modifying
	@Query(value = updateBusinessProcess, nativeQuery = true)
	void updateBusinessProcess(@Param("busiId") String busiId, @Param("business") String business);

	Page<Business> findByProcess(Pageable pageable,Process process);
	
	Optional<Business> findByBusiIdAndProcess(String id, Process process);
}