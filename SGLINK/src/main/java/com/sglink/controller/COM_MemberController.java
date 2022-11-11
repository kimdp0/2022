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

import com.sglink.dto.COM_MemberFormDto;
import com.sglink.entity.COM_Member;
import com.sglink.service.COM_MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/members/com")
@Controller
@RequiredArgsConstructor
public class COM_MemberController {
	private final COM_MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping(value = "/new")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new COM_MemberFormDto());
		return "member/com/memberForm";
	}

	@PostMapping(value = "/new")
	public String newMember(@Validated @ModelAttribute("memberFormDto")COM_MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "member/com/memberForm";
		}
		try {
			COM_Member member = COM_Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/com/memberForm";
		}
		return "redirect:/";
	}

	@GetMapping(value = "/login")
	public String loginMember() {
		return "/member/com/memberLoginForm";
	}

	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
		return "/member/com/memberLoginForm";
	}

}