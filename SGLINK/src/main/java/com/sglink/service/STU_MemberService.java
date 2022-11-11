package com.sglink.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.COM_Member;
import com.sglink.entity.STU_Member;
import com.sglink.repository.STU_MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class STU_MemberService implements UserDetailsService {
	private final STU_MemberRepository memberRepository;

	public STU_Member saveMember(STU_Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(STU_Member member) {
		STU_Member findMember = memberRepository.findByStuuserEmail(member.getStuuserEmail());
		STU_Member userId = memberRepository.findByStuuserId(member.getStuuserId());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다."); // 이미 가입된 회원의 경우 예외를 발생시킨다.
		}else if(userId != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		STU_Member member = memberRepository.findByStuuserEmail(email);
		if (member == null) {
			throw new UsernameNotFoundException(email);
		}
		return User.builder().username(member.getStuuserId()).password(member.getStuuserPw())
				.roles(member.getRole().toString()).build();
	}

}
