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
	@Column(name = "comuserid")
	private String comuserid;
	private String comusername;
	@Column(unique = true)
	private String comuseremail;
	private String comuserpw;
	private String comusertel;
	private String comuseruniname;
	@Enumerated(EnumType.STRING)
	private Role role;

	public static COM_Member createMember(COM_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		COM_Member member = new COM_Member();
		member.setComuserid(memberFormDto.getComuserid());
		member.setComusername(memberFormDto.getComusername());
		member.setComuseremail(memberFormDto.getComuseremail());
		String password = passwordEncoder.encode(memberFormDto.getComuserpw());
		member.setComuserpw(password);
		member.setComusertel(memberFormDto.getComusertel());
		member.setComuseruniname(memberFormDto.getComuseruniname());
		member.setRole(Role.USER);
		return member;
	}
}
