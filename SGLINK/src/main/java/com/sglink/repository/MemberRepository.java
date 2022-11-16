package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.dto.NoticeBoardRequestDto;
import com.sglink.entity.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByUserEmail(String email);
	Member findByUserId(String id);
	
	static final String updateMember = "UPDATE user set "
			+ "user_name = :#{#member.userName}, "
			+ "user_pw = :#{#member.userPw}, "
			+ "user_uniname = :#{#member.userUniname}, "
			+ "update_time = SYSDATE() "
			+ "WHERE user_id = :#{#userId}";
	
	static final String duplicatePw = "select user_pw from user where user_id = :#{#userId} and user_pw = :#{#userPw}";
	static final String duplicateName = "select user_Name from user where user_id = :#{#userId} and user_name = :#{#userName}";
	static final String duplicateUniName = "select user_uniname from user where user_id = :#{#userId} and user_uniname = :#{#userUniname}";
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = updateMember, nativeQuery = true)
	public int updateMember(@Param("member") Member member, @Param("userId") String userId);
	
	@Transactional
	@Query(value = duplicatePw, nativeQuery = true)
	public String duplicatePw(@Param("userId") String userId, @Param("userPw") String userPw);
	
	@Transactional
	@Query(value = duplicateName, nativeQuery = true)
	public String duplicateName(@Param("userId") String userId, @Param("userName") String userName);
	
	@Transactional
	@Query(value = duplicateUniName, nativeQuery = true)
	public String duplicateUniname(@Param("userId") String userId, @Param("userUniname") String userUniname);
}
