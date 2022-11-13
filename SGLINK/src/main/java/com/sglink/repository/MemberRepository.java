package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByUserEmail(String email);
	Member findByUserId(String id);
}
