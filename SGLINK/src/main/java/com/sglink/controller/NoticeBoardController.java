package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sglink.dto.NoticeBoardRequestDto;
import com.sglink.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeBoardController {
	private final NoticeBoardService boardService;
	
	@GetMapping("/board/notice/list")
	public String getBoardListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "5") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", boardService.findAll(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/board/notice/list";
	}
	
	@GetMapping("/board/notice/write")
	public String getBoardWritePage(Model model, NoticeBoardRequestDto boardRequestDto) {
		return "/board/notice/write";
	}
	
	@GetMapping("/board/notice/view")
	public String getBoardViewPage(Model model, NoticeBoardRequestDto boardRequestDto) throws Exception{
		
		try {
			if (boardRequestDto.getId() != null) {
				model.addAttribute("info", boardService.findById(boardRequestDto.getId()));
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "redirect:/board/notice/list";
		
	}
	
	@PostMapping("/board/notice/write/action")
	public String boardWriteAction(Model model, NoticeBoardRequestDto boardRequestDto) throws Exception{
		try {
			Long result = boardService.save(boardRequestDto);
			
			if (result<0) {
				throw new Exception("#Exception boardWriteAction!");
			}
		}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
			return "redirect:/board/notice/list";
		
		}
	
	

}
