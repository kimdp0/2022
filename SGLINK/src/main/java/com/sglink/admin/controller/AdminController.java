package com.sglink.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sglink.admin.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/member/list")
	public String memberListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "10") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", adminService.selectAllMember(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/admin/memberList";
	}
	
	
	@GetMapping("/member/list/delete")
	public String DeleteMember(Model model,@RequestParam("userId")String userId) throws Exception{
		try {
			adminService.deleteMember(userId);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/admin/member/list";
	}
	
	@GetMapping("/company/list")
	public String companyListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "10") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", adminService.selectAllCompany(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/admin/companyList";
	}

}