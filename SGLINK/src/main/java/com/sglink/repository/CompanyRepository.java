package com.sglink.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
	Company findByComId(String comId);
	
	static String updateCompanyProcess = "update company set process = :comProcess where com_id=:comId";
	
	
	@Transactional
	@Modifying
	@Query(value=updateCompanyProcess,nativeQuery = true)
	void updateCompanyProcess(@Param("comId")String comId,@Param("comProcess")String comProcess);
	
}
