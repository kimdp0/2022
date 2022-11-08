package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.COM_Member;

public interface COM_MemberRepository extends JpaRepository<COM_Member, String> {
	COM_Member findByComuserEmail(String email);
}