package com.sglink.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class noticeBoardService {
	private final NoticeBoardRepository noticeBoardRepository;
	
	@Transactional
	public Long save()
}
