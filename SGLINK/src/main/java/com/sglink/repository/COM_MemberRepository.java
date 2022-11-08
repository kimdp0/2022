package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sglink.entity.COM_Member;

public interface COM_MemberRepository extends JpaRepository<COM_Member,Long> {
	
	@Query("Select * from COMPANYUSER sglink.COMUSER_EMAIL = :COMUSER_EMAIL")
	COM_Member findByCOMUSER_EMAIL(@Param("COMUSER_EMAIL") String Email);

}
