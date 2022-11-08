package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.entity.COM_Member;

public interface MemberRepository extends JpaRepository<COM_Member,String> {
	@Query("Select * from COMPANYUSER COMUSER_EMAIL = :COMUSER_EMAIL")
	COM_Member findByCOMUSER_EMAIL(@Param("COMUSER_EMAIL") String Email);

}
