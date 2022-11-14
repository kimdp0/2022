package com.sglink.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.Member;
import com.sglink.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;

	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByUserEmail(member.getUserEmail());
		Member userId = memberRepository.findByUserId(member.getUserId());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다."); // 이미 가입된 회원의 경우 예외를 발생시킨다.
		}else if(userId != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Member member = memberRepository.findByUserId(id);
		if (member == null) {
			throw new UsernameNotFoundException(id);
		}
		return User.builder().username(member.getUserId()).password(member.getUserPw())
				.roles(member.getRole().toString()).build();
	}
	
	
}
