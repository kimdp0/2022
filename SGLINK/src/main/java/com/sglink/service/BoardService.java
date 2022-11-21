package com.sglink.service;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.dto.NoticeBoardRequestDto;
import com.sglink.dto.NoticeBoardResponseDto;
import com.sglink.entity.Board;
import com.sglink.repository.NoticeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final NoticeBoardRepository boardRepository;
	
	@Transactional
	public Long save(NoticeBoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
//	공지게시판 기능구현
//	성능향상readOnly = true
	
	@Transactional(readOnly = true)
	public HashMap <String, Object> findAll(Integer page, Integer size){
		
		HashMap<String, Object> resultMap= new HashMap<String, Object>();
		
		
//		게시글 순서를 내림차순으로 변경Sort.by(Sort.Direncion.DESC,"registerTime")
		Page<Board> list= boardRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"registerTime")));
		
		resultMap.put("list", list.stream().map(NoticeBoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
		
		
		
	}


	
	public NoticeBoardResponseDto findById(Long id) {
		boardRepository.updateBoardReadCntInc(id);
		return new NoticeBoardResponseDto(boardRepository.findById(id).get());
	}
	
	public Optional<Board> viewfindById(Long id) {
		return boardRepository.findById(id);
	}
	
	public int updateBoard(NoticeBoardRequestDto boardRequestDto) {
		return boardRepository.updateBoard(boardRequestDto);
	}
	
	public int updateBoardReadCntInc(Long id) {
		return boardRepository.updateBoardReadCntInc(id);
	}
	
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
	
	public void deleteAll(Long[] deleteId) {
		boardRepository.deleteBoard(deleteId);
	}
	
//	자유게시판=================================
	
	
	
}
