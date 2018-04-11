package org.Isaveu.controller;

import javax.annotation.Resource;

import org.Isaveu.mapper.HrMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Resource(name = "org.Isaveu.mapper.HrMapper")
	HrMapper hMapper;
	
	@RequestMapping("/")
	private String index() {
		System.out.println("/");
		return "index";
	}
	
	@RequestMapping("/accessDenied")
	private String accessDenied() {
		System.out.println("/");
		return "accessDenied";
	}
	
	//추후 차단 예정
	@RequestMapping("/admin/admin")
	private String jsptest() throws Exception{
		System.out.println("/admin/admin");
		return "admin/admin";
	}
	
	@RequestMapping("/admin/ex")
	private String extest() throws Exception{
		System.out.println("/admin/extinguisher");
		return "admin/extinguisher";
	}
	
	@RequestMapping("/admin/sensor1")
	private String ss1test() throws Exception{
		System.out.println("/admin/sensor1");
		return "admin/sensorLog1";
	}
	@RequestMapping("/admin/event")
	private String eventtest() throws Exception{
		System.out.println("/admin/event");
			return "admin/eventlog";
	}
	@RequestMapping("/admin/stream")
	private String sttest() throws Exception{
		System.out.println("/admin/stream");
		return "admin/streaming";
	}
	@RequestMapping("/admin/index")
	private String hrtest() throws Exception{
		System.out.println("/admin/index");
		return "admin/login";
	}
	@RequestMapping("/admin/cal")
	private String calTest() throws Exception{
		System.out.println("/admin/cal");
		return "Calendar/schedule";
	}
	@RequestMapping("/admin/mchart1")
	private String mchartTest() throws Exception{
		System.out.println("/admin/cal");
		return "mobile/mchart0";
	}

	
}
