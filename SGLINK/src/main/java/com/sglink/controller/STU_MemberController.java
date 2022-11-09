package com.sglink.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sglink.dto.STU_MemberFormDto;
import com.sglink.entity.STU_Member;
import com.sglink.service.STU_MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/members/stu")
@Controller
@RequiredArgsConstructor
public class STU_MemberController {
	private final STU_MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping(value = "/new")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new STU_MemberFormDto());
		return "member/stu/memberForm";
	}

	@PostMapping(value = "/new")
	public String newMember(@Validated @ModelAttribute("memberFormDto")STU_MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "member/stu/memberForm";
		}
		try {
			STU_Member member = STU_Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/stu/memberForm";
		}
		return "redirect:/";
	}

	@GetMapping(value = "/login")
	public String loginMember() {
		return "/member/memberLoginForm";
	}

	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
		return "/member/memberLoginForm";
	}

}