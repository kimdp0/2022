package com.sglink.member.service;

import java.security.Principal;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.EquipmentReservation;
import com.sglink.entity.Member;
import com.sglink.equipment.dto.EquipmentReservationResponseDto;
import com.sglink.repository.EquipmentReservationRepository;
import com.sglink.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;
	private final EquipmentReservationRepository equipmentReservationRepository;
	

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
		String userName = memberRepository.duplicateName(userId, member.getUserName());
		if (userPw != null) {
			throw new IllegalStateException("비밀번호가 이전과 동일합니다."); 
		}else if(userName != null) {
			throw new IllegalStateException("이름이 이전과 동일합니다.");
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
	
	public Member findbyId(String id) {
		return memberRepository.findByUserId(id);
	}
	
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> selectAllEquipmentReservation(String userId,Integer page, Integer size) {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Page<EquipmentReservation> list = equipmentReservationRepository
				.findByEquiRegisterId(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "startDate")),userId);

		resultMap.put("list", list.stream().map(EquipmentReservationResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());

		return resultMap;
	}
	
	

	
	
}
