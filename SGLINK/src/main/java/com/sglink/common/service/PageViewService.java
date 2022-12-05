package com.sglink.common.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.common.dto.PageViewRequestDto;
import com.sglink.common.dto.PageViewResponsetDto;

import com.sglink.entity.Introduce;
import com.sglink.repository.IntroduceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PageViewService {
	private final IntroduceRepository introduceRepository;
	
	
	
	@Transactional
	public Long save(PageViewRequestDto boardSaveDto) {
		return introduceRepository.save(boardSaveDto.toEntity()).getId();
	}
	

	public PageViewResponsetDto findById(Long id) {
		return new PageViewResponsetDto(introduceRepository.findById(id).get());
	}
	
	public Optional<Introduce> viewfindById(Long id) {
		return introduceRepository.findById(id);
	}
	

}
