package com.sglink.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sglink.dto.COM_MemberFormDto;
import com.sglink.dto.STU_MemberFormDto;
import com.sglink.entity.Member;
import com.sglink.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping(value = "/com/new")
	public String memberComForm(Model model) {
		model.addAttribute("memberFormDto", new COM_MemberFormDto());
		return "member/com/memberForm";
	}
	

	@PostMapping(value = "/com/new")
	public String mewComMember(@Valid @ModelAttribute("memberFormDto")COM_MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "member/com/memberForm";
		}
		try {
			Member member = Member.createComMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/com/memberForm";
		}
		return "redirect:/";
	}
	
	@GetMapping(value = "/stu/new")
	public String memberStuForm(Model model) {
		model.addAttribute("memberFormDto", new STU_MemberFormDto());
		return "member/stu/memberForm";
	}

	
	@PostMapping(value = "/stu/new")
	public String newStuMember(@Valid @ModelAttribute("memberFormDto")STU_MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "member/stu/memberForm";
		}
		try {
			Member member = Member.createStuMember(memberFormDto, passwordEncoder);
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
	
	
	@GetMapping(value = "/memberRole")
	public String memberRole(Model model) {
		return "member/memberRole";
	}
	
	@ResponseBody
	@GetMapping(value="/userid")
	public String getUserId(Principal pirncipal) {
		String userId = memberService.getUserId(pirncipal);
		Member member = memberService.getMember(userId);
		return member.getUserName();
		
	}
	
	@GetMapping(value="/mypage")
	public String mypageForm(Model model, Principal pirncipal) {
		String userId = memberService.getUserId(pirncipal);
		Member member = memberService.getMember(userId);
		model.addAttribute("info",member);
		return "/member/mypage/memberUpdateForm";
	}
	

}