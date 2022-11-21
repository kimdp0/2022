package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/comsup")
@Controller
public class InfraController {
	@RequestMapping(value = "/infra/introduce", method = RequestMethod.GET)
	public String introduce() {
		return "/board/comsup/infra/introduce";
	}
	@RequestMapping(value = "/infra/application", method = RequestMethod.GET)
	public String application() {
		return "/board/comsup/infra/application";
	}
	@RequestMapping(value = "/infra/howto", method = RequestMethod.GET)
	public String howto() {
		return "/board/comsup/infra/howto";
	}
	@RequestMapping(value = "/infra/onlineapplication", method = RequestMethod.GET)
	public String onlineapplication() {
		return "/board/comsup/infra/onlineapplication";
	}
	@RequestMapping(value = "/infra/precaution", method = RequestMethod.GET)
	public String precaution() {
		return "/board/comsup/infra/precaution";
	}
}