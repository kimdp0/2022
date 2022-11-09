package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sglink.constant.Role;
import com.sglink.dto.STU_MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "studentuser")
@Getter
@Setter
@ToString
public class STU_Member {
	@Id
	@Column(name = "stuuserId")
	private String stuuserId;
	private String stuuserName;
	@Column(unique = true)
	private String stuuserEmail;
	private String stuuserPw;
	private String stuuserTel;
	private String stuuserUniname;
	@Enumerated(EnumType.STRING)
	private Role role;

	public static STU_Member createMember(STU_MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		STU_Member member = new STU_Member();
		member.setStuuserId(memberFormDto.getStuuserId());
		member.setStuuserName(memberFormDto.getStuuserName());
		member.setStuuserEmail(memberFormDto.getStuuserEmail());
		String password = passwordEncoder.encode(memberFormDto.getStuuserPw());
		member.setStuuserPw(password);
		member.setStuuserTel(memberFormDto.getStuuserTel());
		member.setStuuserUniname(memberFormDto.getStuuserUniname());
		member.setRole(Role.USER);
		return member;
	}
}
