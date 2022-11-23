package com.sglink.board.service;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.board.dto.FileBoardRequestDto;
import com.sglink.board.dto.FileBoardResponseDto;
import com.sglink.board.dto.NoticeBoardRequestDto;
import com.sglink.board.dto.NoticeBoardResponseDto;
import com.sglink.entity.Board;
import com.sglink.entity.FileBoard;
import com.sglink.repository.FileBoardRepository;
import com.sglink.repository.FileRepository;
import com.sglink.repository.NoticeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final NoticeBoardRepository noticeboardRepository;
	private final FileBoardRepository fileboardRepository;
	private final FileRepository fileRepository;
	
	
	
	public FileBoard boardfindById(Long id) {
		return fileboardRepository.findOneById(id);
		
	}
//	공지게시판 기능구현--------------------------------------------
	
	
	@Transactional
	public Long save(NoticeBoardRequestDto boardSaveDto) {
		return noticeboardRepository.save(boardSaveDto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	public HashMap <String, Object> findAll(Integer page, Integer size){
		HashMap<String, Object> resultMap= new HashMap<String, Object>();	
//		게시글 순서를 내림차순으로 변경Sort.by(Sort.Direncion.DESC,"registerTime")
		Page<Board> list= noticeboardRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"registerTime")));
		resultMap.put("list", list.stream().map(NoticeBoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());	
		return resultMap;	
	}
	

	public NoticeBoardResponseDto findById(Long id) {
		noticeboardRepository.updateBoardReadCntInc(id);
		return new NoticeBoardResponseDto(noticeboardRepository.findById(id).get());
	}
	
	public Optional<Board> viewfindById(Long id) {
		return noticeboardRepository.findById(id);
	}
	
	public int updateBoard(NoticeBoardRequestDto boardRequestDto) {
		return noticeboardRepository.updateBoard(boardRequestDto);
	}
	
	public int updateBoardReadCntInc(Long id) {
		return noticeboardRepository.updateBoardReadCntInc(id);
	}
	
	public void deleteById(Long id) {
		noticeboardRepository.deleteById(id);
	}
	
	public void deleteAll(Long[] deleteId) {
		noticeboardRepository.deleteBoard(deleteId);
	}
	
	
//  자료실게시판기능구현---------------------------------
	@Transactional
	public Long save(FileBoardRequestDto fileboardSaveDto) {
		return fileboardRepository.save(fileboardSaveDto.toEntity()).getId();
	}
	
	public FileBoard findByFileId(Long id) {
		
		return fileboardRepository.findOneById(id);
	}
	
	@Transactional(readOnly = true)
	public HashMap <String, Object> findAllFile(Integer page, Integer size){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Page<FileBoard> list= fileboardRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"registerTime")));
		
		resultMap.put("list",list.stream().map(FileBoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt",list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}
	
	public FileBoardResponseDto filefindById(Long id) {
		fileboardRepository.updateFileBoardReadCntInc(id);
		return new FileBoardResponseDto(fileboardRepository.findById(id).get());
	}
	
	public Optional<FileBoard> fileviewfindById(Long id){
		return fileboardRepository.findById(id);
	}
	
	public int updatefileBoard(FileBoardRequestDto boardRequestDto) {
		return fileboardRepository.updateBoard(boardRequestDto);
	}
	
	public int updatefileBoardReadCntInc(Long id) {
		return fileboardRepository.updateFileBoardReadCntInc(id);
	}
	
	public void filedeleteById(Long id) {
		fileRepository.deleteFileByBoardId(id);
		fileboardRepository.deleteById(id);
	}
	
	public void filedeleteAll(Long[] deleteId) {
		fileRepository.deleteAllFileByBoardId(deleteId);
		fileboardRepository.deleteFileBoard(deleteId);
	}
//	자유게시판기능구현=================================
	
	
	
}

