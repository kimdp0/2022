package com.sglink.service;

import java.security.Principal;

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
	
	public int updateMember(Member member,String userId) {
		duplicateMember(member, userId);
		return memberRepository.updateMember(member,userId);
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
	
	private void duplicateMember(Member member ,String userId) {
		String userPw = memberRepository.duplicatePw(userId, member.getUserPw());
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println(member.getUserPw());
		System.out.println(userPw);
		System.out.println("------------------------------------------------------------------------------------------");
		String userName = memberRepository.duplicateName(userId, member.getUserName());
		String userUniname = memberRepository.duplicateUniname(userId, member.getUserUniname());
		if (userPw != null) {
			throw new IllegalStateException("비밀번호가 이전과 동일합니다."); // 이미 가입된 회원의 경우 예외를 발생시킨다.
		}else if(userName != null) {
			throw new IllegalStateException("이름이 이전과 동일합니다.");
		}else if(userUniname != null) {
			throw new IllegalStateException("기관명이 이전과 동일합니다.");
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
	
	public String getUserId(Principal pirncipal) {
		return pirncipal.getName();	
	}
	
	public Member getMember(String userId) {
		return memberRepository.getById(userId);
	}
	
	
}
