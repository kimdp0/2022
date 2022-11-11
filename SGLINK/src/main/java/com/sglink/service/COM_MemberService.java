package com.sglink.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.COM_Member;
import com.sglink.repository.COM_MemberRepository;


import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class COM_MemberService implements UserDetailsService {
	private final COM_MemberRepository memberRepository;

	public COM_Member saveMember(COM_Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(COM_Member member) {
		COM_Member findMember = memberRepository.findByComuserEmail(member.getComuserEmail());
		COM_Member userId = memberRepository.findByComuserId(member.getComuserId());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다."); // 이미 가입된 회원의 경우 예외를 발생시킨다.
		}else if(userId != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		COM_Member member = memberRepository.findByComuserId(id);
		if (member == null) {
			throw new UsernameNotFoundException(id);
		}
		return User.builder().username(member.getComuserId()).password(member.getComuserPw())
				.roles(member.getRole().toString()).build();
	}

}
