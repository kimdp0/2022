package com.sglink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/comsup")
@Controller
public class FamilyComController {
	@RequestMapping(value = "/family/introduce", method = RequestMethod.GET)
	public String introduce() {
		return "/board/comsup/family/introduce";
	}
	@RequestMapping(value = "/family/application", method = RequestMethod.GET)
	public String application() {
		return "/board/comsup/family/application";
	}
	@RequestMapping(value = "/family/status", method = RequestMethod.GET)
	public String status() {
		return "/board/comsup/family/status";
	}
	@RequestMapping(value = "/family/forum", method = RequestMethod.GET)
	public String forum() {
		return "/board/comsup/family/forum";
	}
}