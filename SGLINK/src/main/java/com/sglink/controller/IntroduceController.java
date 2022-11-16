package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/introduce")
@Controller
public class IntroduceController {
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting() {
		return "/board/introduce/greeting";
	}
	
	@RequestMapping(value = "/vision", method = RequestMethod.GET)
	public String vision() {
		return "/board/introduce/vision";
	}
	
	@RequestMapping(value = "/organization", method = RequestMethod.GET)
	public String organization() {
		return "/board/introduce/organization";
	}
	
	@RequestMapping(value = "/direction", method = RequestMethod.GET)
	public String direction() {
		return "/board/introduce/direction";
	}

}
