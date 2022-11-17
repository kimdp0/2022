package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class MainController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main() {
		return "/main/main";
	}
	
	
	@RequestMapping(value="/layout", method = RequestMethod.GET)
	public String layout() {
		return "/layouts/content";
	}
	
	@GetMapping("/com")
	public String comForm(){
		return "/com/comNotice";
	}

}