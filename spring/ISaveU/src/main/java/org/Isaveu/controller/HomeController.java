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
		return "index";
	}
	@RequestMapping("/test")
	private String test() {
		return "NewIndex";
	}
	
	@RequestMapping("/accessDenied")
	private String accessDenied() {
		return "accessDenied";
	}
	
	//추후 차단 예정
	@RequestMapping("/admin")
	private String jsptest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin/admin";
	}
	
	@RequestMapping("admin/ex")
	private String extest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin/extinguisher";
	}
	
	@RequestMapping("admin/sensor1")
	private String ss1test() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin/sensorLog1";
	}
	@RequestMapping("admin/sensor2")
	private String ss2test() throws Exception{
//			System.out.println(hMapper.hrCount()); 
			return "admin/sensorLog2";
	}
	@RequestMapping("admin/sensor3")
	private String ss3test() throws Exception{
//			System.out.println(hMapper.hrCount()); 
			return "admin/sensorLog3";
	}
	@RequestMapping("admin/event")
	private String eventtest() throws Exception{
//			System.out.println(hMapper.hrCount()); 
			return "admin/eventlog";
	}
	@RequestMapping("admin/stream")
	private String sttest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin/streaming";
	}
	@RequestMapping("admin/hr")
	private String hrtest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin/registerhr";
	}
	@RequestMapping("/cal")
	private String calTest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "Calendar/schedule";
	}
	@RequestMapping("mobile/mchart1")
	private String mchartTest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "mobile/mchart0";
	}

	
}
