package com.sglink.equipment.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sglink.entity.Company;
import com.sglink.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="/equipment")
@RequiredArgsConstructor
@Controller
public class EquipmentController {
	
	private final MemberService memberService;
	//장비 관련 페이지
		@RequestMapping(value="/view", method = RequestMethod.GET)
		public String main() {
			return "/equipment/equipment/equipmentList";
		}
		
		@GetMapping(value="/new")
		public String newEquipment(Model model,Principal principal) {
			String userId = principal.getName();
			Company company =  memberService.findbyId(userId).getCompany();
			String comUniname = company.getComUniname();
			model.addAttribute("comUniname", comUniname);
			return "/equipment/equipment/equipmentRegist";
		}

}
