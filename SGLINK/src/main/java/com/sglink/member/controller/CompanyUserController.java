package com.sglink.member.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sglink.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/comuser")
@Controller
@RequiredArgsConstructor
public class CompanyUserController {
	private final MemberService memberService;
	
	
	@GetMapping(value="/business/list")
	public String busiListPage() {
		return "/member/comuser/comuserBusiList";
	}
	
	@GetMapping("/equipment/list")
	public String equipmentListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page,
			@RequestParam(required = false, defaultValue= "10") Integer size, Principal principal)throws Exception{
		try {
			String userId = principal.getName();
			model.addAttribute("resultMap", memberService.selectAllEquipmentReservation(userId,page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/member/comuser/comuserEquiList";
	}


}