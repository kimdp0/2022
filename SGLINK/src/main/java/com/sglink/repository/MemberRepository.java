package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByUserEmail(String email);
	Member findByUserId(String id);
	
}
