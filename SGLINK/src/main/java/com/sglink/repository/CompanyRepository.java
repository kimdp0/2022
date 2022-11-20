package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
	Company findByComId(String comId);
}
