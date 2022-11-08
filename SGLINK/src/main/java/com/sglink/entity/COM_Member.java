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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COMPANYUSER")
@Getter
@Setter
@ToString
public class COM_Member {
	@Id
	@Column(name = "COMUSER_ID")
	private String COMUSER_ID;
	private String COMUSER_NAME;
	@Column(unique = true)
	private String COMUSER_EMAIL;
	private String COMUSER_PW;
	private String COMUSER_TEL;
	private String COMUSER_UNINAME;
	@Enumerated(EnumType.STRING)
	private Role role;

	public static COM_Member createMember(COM_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		COM_Member member = new COM_Member();
		member.setCOMUSER_ID(memberFormDto.getCOMUSER_ID());
		member.setCOMUSER_NAME(memberFormDto.getCOMUSER_NAME());
		member.setCOMUSER_EMAIL(memberFormDto.getCOMUSER_EMAIL());
		String password = passwordEncoder.encode(memberFormDto.getCOMUSER_PW());
		member.setCOMUSER_PW(password);
		member.setCOMUSER_TEL(memberFormDto.getCOMUSER_TEL());
		member.setCOMUSER_UNINAME(member.getCOMUSER_UNINAME());
		member.setRole(Role.USER);
		return member;
	}
}
