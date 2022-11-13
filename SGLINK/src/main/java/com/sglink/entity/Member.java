package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sglink.constant.Role;
import com.sglink.dto.COM_MemberFormDto;
import com.sglink.dto.STU_MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class Member {
	@Id
	@Column(name = "userId")
	private String userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPw;
	private String userTel;
	private String userUniname;
	@Enumerated(EnumType.STRING)
	private Role role;

	public static Member createComMember(COM_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setUserId(memberFormDto.getComuserId());
		member.setUserName(memberFormDto.getComuserName());
		member.setUserEmail(memberFormDto.getComuserEmail());
		String password = passwordEncoder.encode(memberFormDto.getComuserPw());
		member.setUserPw(password);
		member.setUserTel(memberFormDto.getComuserTel());
		member.setUserUniname(memberFormDto.getComuserUniname());
		member.setRole(Role.COM);
		return member;
	}
	
	public static Member createStuMember(STU_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setUserId(memberFormDto.getStuuserId());
		member.setUserName(memberFormDto.getStuuserName());
		member.setUserEmail(memberFormDto.getStuuserEmail());
		String password = passwordEncoder.encode(memberFormDto.getStuuserPw());
		member.setUserPw(password);
		member.setUserTel(memberFormDto.getStuuserTel());
		member.setUserUniname(memberFormDto.getStuuserUniname());
		member.setRole(Role.STU);
		return member;
	}
}
