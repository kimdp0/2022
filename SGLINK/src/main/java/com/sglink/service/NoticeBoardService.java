package com.sglink.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.dto.NoticeBoardRequestDto;
import com.sglink.dto.NoticeBoardResponseDto;
import com.sglink.repository.NoticeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeBoardService {
	private final NoticeBoardRepository boardRepository;
	
	@Transactional
	public Long save(NoticeBoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List <NoticeBoardResponseDto> findAll(){
		return boardRepository.findAll().stream().map(NoticeBoardResponseDto::new).collect(Collectors.toList());
		
	}
	
	public NoticeBoardResponseDto findById(Long id) {
		return new NoticeBoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(NoticeBoardRequestDto boardRequestDto) {
		return boardRepository.updateBoard(boardRequestDto);
	}
	
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
}
