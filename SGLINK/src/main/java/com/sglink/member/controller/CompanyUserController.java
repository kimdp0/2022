package com.sglink.member.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sglink.company.service.CompanyService;
import com.sglink.entity.Company;
import com.sglink.entity.Member;
import com.sglink.member.dto.COM_MemberFormDto;
import com.sglink.member.dto.STU_MemberFormDto;
import com.sglink.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/comuser")
@Controller
@RequiredArgsConstructor
public class CompanyUserController {
	private final MemberService memberService;
	private final CompanyService companyService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping(value="/equipment/list")
	public String equiListPage() {
		return "/member/comuser/comuserEquiList";
	}
	
	@GetMapping(value="/business/list")
	public String busiListPage() {
		return "/member/comuser/comuserBusiList";
	}
	


}