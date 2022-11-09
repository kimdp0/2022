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
@Table(name = "companyuser")
@Getter
@Setter
@ToString
public class COM_Member {
	@Id
	@Column(name = "comuserId")
	private String comuserId;
	private String comuserName;
	@Column(unique = true)
	private String comuserEmail;
	private String comuserPw;
	private String comuserTel;
	private String comuserUniname;
	@Enumerated(EnumType.STRING)
	private Role role;

	public static COM_Member createMember(COM_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		COM_Member member = new COM_Member();
		member.setComuserId(memberFormDto.getComuserId());
		member.setComuserName(memberFormDto.getComuserName());
		member.setComuserEmail(memberFormDto.getComuserEmail());
		String password = passwordEncoder.encode(memberFormDto.getComuserPw());
		member.setComuserPw(password);
		member.setComuserTel(memberFormDto.getComuserTel());
		member.setComuserUniname(memberFormDto.getComuserUniname());
		member.setRole(Role.USER);
		return member;
	}
}
