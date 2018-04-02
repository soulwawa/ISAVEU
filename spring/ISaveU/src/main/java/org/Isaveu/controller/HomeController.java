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
	
	//추후 차단 예정
	@RequestMapping("/admin")
	private String jsptest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "admin";
	}
	
	@RequestMapping("/ex")
	private String extest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "extinguisher";
	}
	
	@RequestMapping("/sensor")
	private String sstest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "sensorLog";
	}
	@RequestMapping("/stream")
	private String sttest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "streaming";
	}
	@RequestMapping("/hr")
	private String hrtest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "registerhr";
	}
	@RequestMapping("/cal")
	private String calTest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "Calendar/schedule";
	}

	
}
