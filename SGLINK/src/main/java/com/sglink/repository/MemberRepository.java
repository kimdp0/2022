package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	String delete_member = "DELETE FROM user "
			+ "WHERE ID IN (:deleteList)";
	
	Member findByUserEmail(String email);
	Member findByUserId(String id);
	
	@Transactional
	@Modifying
	@Query(value = delete_member, nativeQuery = true)
	public int deleteMember(@Param("deleteList") Long[] deleteList);
}
