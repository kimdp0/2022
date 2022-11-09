package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.STU_Member;


public interface STU_MemberRepository extends JpaRepository<STU_Member, String> {
	STU_Member findByStuuserEmail(String email);
	STU_Member findByStuuserId(String id);
	
}
