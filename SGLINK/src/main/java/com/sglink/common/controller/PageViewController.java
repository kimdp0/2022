package com.sglink.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageViewController {
	
	//장비 관련 페이지
	@RequestMapping(value="/equipment/view", method = RequestMethod.GET)
	public String main() {
		return "/pageView/equipment/equipment/equipmentList";
	}
	
	@GetMapping(value="/equipment/new")
	public String newEquipment() {
		return "/pageView/equipment/equipment/equipmentRegist";
	}
	//가족기업 관련 페이지 ------------------------------------------------------------------------
	@RequestMapping(value = "/comsup/family/introduce", method = RequestMethod.GET)
	public String familyIntroduce() {
		return "/pageView/comsup/family/introduce";
	}
	@RequestMapping(value = "/comsup/family/application", method = RequestMethod.GET)
	public String familyApplication() {
		return "/pageView/comsup/family/application";
	}
	@RequestMapping(value = "/comsup/family/status", method = RequestMethod.GET)
	public String familyStatus() {
		return "/pageView/comsup/family/status";
	}
	@RequestMapping(value = "/comsup/family/forum", method = RequestMethod.GET)
	public String familyforum() {
		return "/pageView/comsup/family/forum";
	}
	
	
	
	//인프라--------------------------------------------------------------------------------
	@RequestMapping(value = "/comsup/infra/introduce", method = RequestMethod.GET)
	public String InfraIntroduce() {
		return "/pageView/comsup/infra/introduce";
	}
	@RequestMapping(value = "/comsup/infra/application", method = RequestMethod.GET)
	public String InfraApplication() {
		return "/pageView/comsup/infra/application";
	}
	@RequestMapping(value = "/comsup/infra/howto", method = RequestMethod.GET)
	public String Infrahowto() {
		return "/pageView/comsup/infra/howto";
	}
	@RequestMapping(value = "/comsup/infra/onlineapplication", method = RequestMethod.GET)
	public String Infraonlineapplication() {
		return "/pageView/comsup/infra/onlineapplication";
	}
	@RequestMapping(value = "/comsup/infra/precaution", method = RequestMethod.GET)
	public String Infraprecaution() {
		return "/pageView/comsup/infra/precaution";
	}
	@RequestMapping(value = "/comsup/infra/equipmentregist", method = RequestMethod.GET)
	public String Infraequipmentregist() {
		return "/pageView/equipment/equipment/equipmentRegist";
	}
	
	
	
	//사업단소개--------------------------------------------------------------------------
	@RequestMapping(value = "/introduce/greeting", method = RequestMethod.GET)
	public String greeting() {
		return "/pageView/introduce/greeting";
	}
	
	@RequestMapping(value = "/introduce/vision", method = RequestMethod.GET)
	public String vision() {
		return "/pageView/introduce/vision";
	}
	
	@RequestMapping(value = "/introduce/organization", method = RequestMethod.GET)
	public String organization() {
		return "/pageView/introduce/organization";
	}
	
	@RequestMapping(value = "/introduce/direction", method = RequestMethod.GET)
	public String direction() {
		return "/pageView/introduce/direction";
	}
	
	//오픈 이노베이션-------------------------------------------------------------------------
	@RequestMapping(value = "/comsup/openino/introduce", method = RequestMethod.GET)
	public String OpenIntroduce() {
		return "/pageView/comsup/openino/introduce";
	}
	@RequestMapping(value = "/comsup/openino/model", method = RequestMethod.GET)
	public String OpenModel() {
		return "/pageView/comsup/openino/model";
	}
	@RequestMapping(value = "/comsup/openino/board", method = RequestMethod.GET)
	public String OpenBoard() {
		return "/pageView/comsup/openino/board";
	}
	
	//학생지원 관련 페이지-----------------------------------------------------------------
	@RequestMapping(value = "/stusup/cooperation/introduce", method = RequestMethod.GET)
	public String StuIntroduce() {
		return "/pageView/stusup/cooperation/introduce";
	}
	@RequestMapping(value = "/stusup/cooperation/open", method = RequestMethod.GET)
	public String StuOpen() {
		return "/pageView/stusup/cooperation/open";
	}
	@RequestMapping(value = "/stusup/cooperation/independent", method = RequestMethod.GET)
	public String StuIndependent() {
		return "/pageView/stusup/cooperation/independent";
	}
	
	
	//커뮤니티------------------------------------------------------------------------------
	
	@GetMapping(value="/community/cmntEvent")
	public String cmntEvent() {
		return "/pageView/cmnt/cmntEvent";
	}
	
	@GetMapping(value="/community/eventSchedule")
	public String eventSchedule() {
		return "/pageView/cmnt/eventSchedule";
	}
	

	@GetMapping(value="/community/news")
	public String news() {
		return "/pageView/cmnt/news";
	}
}
