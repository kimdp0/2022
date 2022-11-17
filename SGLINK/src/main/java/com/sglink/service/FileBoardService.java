package com.sglink.service;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.dto.FileBoardRequestDto;
import com.sglink.dto.FileBoardResponseDto;
import com.sglink.entity.FileBoard;
import com.sglink.repository.FileBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileBoardService {
	private final FileBoardRepository fileboardRepository;
	
	@Transactional
	public Long save(FileBoardRequestDto fileboardSaveDto) {
		return fileboardRepository.save(fileboardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public HashMap <String, Object> findAll(Integer page, Integer size){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Page<FileBoard> list= fileboardRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"registerTime")));
		
		resultMap.put("list",list.stream().map(FileBoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt",list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}
	
	public FileBoardResponseDto findById(Long id) {
		fileboardRepository.updateFileBoardReadCntInc(id);
		return new FileBoardResponseDto(fileboardRepository.findById(id).get());
	}
	
	public Optional<FileBoard> viewfindById(Long id){
		return fileboardRepository.findById(id);
	}
	
	public int updateBoard(FileBoardRequestDto fileboardRequestDto) {
		return fileboardRepository.updatefileBoard(fileboardRequestDto);
	}
	
	public int updateBoardReadCntInc(Long id) {
		return fileboardRepository.updateFileBoardReadCntInc(id);
	}
	
	public void deleteById(Long id) {
		fileboardRepository.deleteById(id);
	}
	
	public void deleteAll(Long[] deleteId) {
		fileboardRepository.deleteFileBoard(deleteId);
	}
	
	
	

}
