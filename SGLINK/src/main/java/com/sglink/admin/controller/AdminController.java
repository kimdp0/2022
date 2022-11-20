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
	public String getBoardListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "10") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", adminService.selectAll(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/admins/memberList";
	}
	
//	@PostMapping("/member/list/delete")
//	public String BoardDeleteAction(Model model, @RequestParam() Long[] deleteId) throws Exception{
//		
//		try {
//			adminService.deleteMember(deleteId);
//		}catch(Exception e) {
//			throw new Exception(e.getMessage());
//		}
//		return "redirect:/admin/member/list";
//	}
	
	@GetMapping("/member/list/delete")
	public String DeleteMember(Model model,@RequestParam("userId")String userId) throws Exception{
		try {
			adminService.deleteMember(userId);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/admin/member/list";
	}

}