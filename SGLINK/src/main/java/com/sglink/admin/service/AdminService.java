package com.sglink.admin.service;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.admin.dto.MemberResponseDto;
import com.sglink.entity.Member;
import com.sglink.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AdminService {
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@Transactional(readOnly = true)
	public HashMap <String, Object> selectAll(Integer page, Integer size){
		
		HashMap<String, Object> resultMap= new HashMap<String, Object>();
		
		
//		게시글 순서를 내림차순으로 변경Sort.by(Sort.Direncion.DESC,"registerTime")
		Page<Member> list= memberRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"registerTime")));
		
		resultMap.put("list", list.stream().map(MemberResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;	
	}
	
	public void deleteMember(String userId) {
		memberRepository.deleteById(userId);
	}

}
