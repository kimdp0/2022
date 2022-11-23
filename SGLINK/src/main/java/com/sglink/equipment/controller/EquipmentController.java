package com.sglink.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/equipment")
@Controller
public class EquipmentController {
	//장비 관련 페이지
		@RequestMapping(value="/view", method = RequestMethod.GET)
		public String main() {
			return "/equipment/equipment/equipmentList";
		}
		
		@GetMapping(value="/new")
		public String newEquipment() {
			return "/equipment/equipment/equipmentRegist";
		}

}
