package com.sglink.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sglink.dto.NoticeBoardRequestDto;
import com.sglink.entity.Member;
import com.sglink.service.MemberService;
import com.sglink.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="/boards")
@RequiredArgsConstructor
@Controller
public class NoticeBoardController {
	private final NoticeBoardService boardService;
	private final MemberService memberService;
	
	
//	@RequestParam(required = false, defaultValue= "10")  defaultValue= "10"<-숫자 변경시 페이지당 게시글숫자달라짐
	@GetMapping("/notice/list")
	public String getBoardListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "10") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", boardService.findAll(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/board/notice/list";
	}
	
	@GetMapping("/notice/write")
	public String getBoardWritePage(Model model, NoticeBoardRequestDto boardRequestDto,Principal pirncipal) {
		
		String userId = memberService.getUserId(pirncipal);
		Member member = memberService.getMember(userId);
		
		model.addAttribute("info", member);
		return "/board/notice/write";
	}
	
	@GetMapping("/notice/view")
	public String getBoardViewPage(Model model, NoticeBoardRequestDto boardRequestDto) throws Exception{
		
		try {
			if (boardRequestDto.getId() != null) {
				model.addAttribute("info", boardService.findById(boardRequestDto.getId()));
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "/board/notice/view";
		
	}
	
	@PostMapping("/notice/write/action")
	public String boardWriteAction(Model model, NoticeBoardRequestDto boardRequestDto) throws Exception{
		try {
			Long result = boardService.save(boardRequestDto);
			
			if (result<0) {
				throw new Exception("#Exception boardWriteAction!");
			}
		}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
			return "redirect:/boards/notice/list";
		
		}
	
	@PostMapping("/notice/view/action")
	public String getBoardViewAction(Model model, NoticeBoardRequestDto boardRequestDto) throws Exception{

		try {
			int result = boardService.updateBoard(boardRequestDto);
			if (result<1) {
				throw new Exception("#Exception boardViewAction!");
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/boards/notice/list";
	}
	
	@GetMapping("/notice/view/delete")
	public String BoardViewDeleteAction(Model model, @RequestParam("id")Long id) throws Exception{

		try {
			boardService.deleteById(id);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "redirect:/boards/notice/list";
	}
	
	@GetMapping("/notice/delete")
	public String BoardDeleteAction(Model model, @RequestParam() Long[] deleteId) throws Exception{
		
		try {
			boardService.deleteAll(deleteId);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/boards/notice/list";
	}
	

}
