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
	private String jsptest() throws Exception{
//		System.out.println(hMapper.hrCount()); 
		return "test";
	}
}
