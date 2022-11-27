package com.sglink.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sglink.admin.service.AdminService;
import com.sglink.repository.MemberRepository;

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
		return "/admin/admin/memberList";
	}
	
	
	@GetMapping("/member/list/delete")
	public String deleteMember(Model model,@RequestParam("userId")String userId) throws Exception{
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
		return "/admin/admin/companyList";
	}
	
	@GetMapping("/company/list/approve")
	public String approveCompany(@RequestParam("comId")String comId,@RequestParam("comProcess")String comProcess) {
		adminService.approveCompany(comId,comProcess);
		return "redirect:/admin/company/list";
	}
	
	
	
	@GetMapping("/equipment/list")
	public String equipmentListPage(Model model, @RequestParam(required= false, defaultValue= "0") Integer page, @RequestParam(required = false, defaultValue= "10") Integer size)throws Exception{
		try {
			model.addAttribute("resultMap", adminService.selectAllEquipment(page, size));
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return "/admin/admin/equipmentList";
	}
	
	@GetMapping("/equipment/list/approve")
	public String approveEquipment(@RequestParam("equiId")String equiId,@RequestParam("equiProcess")String equiProcess) {
		adminService.approveEquipment(equiId,equiProcess);
		return "redirect:/admin/equipment/list";
	}

}