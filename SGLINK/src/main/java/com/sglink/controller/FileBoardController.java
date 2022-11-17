package com.sglink.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sglink.entity.FileBoard;
import com.sglink.service.FileBoardService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fileboard")
public class FileBoardController {
	
	private final FileBoardService fileboardService;
	
	@GetMapping
	public String fileboard(Model model) {
		System.out.println("은비꺼");

		return "fileboard/fileboard";
		
	}
	

}
