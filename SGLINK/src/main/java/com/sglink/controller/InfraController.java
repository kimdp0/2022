package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/comsup")
@Controller
public class InfraController {
	@RequestMapping(value = "/infra/application", method = RequestMethod.GET)
	public String introduce() {
		return "/board/comsup/infra/application";
	}
}