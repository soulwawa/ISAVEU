package org.Isaveu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.Isaveu.domain.TbFireExVO;
import org.Isaveu.service.FireExService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FireExController {
	
	@Resource(name = "org.Isave.service.FireExService")
	FireExService fService;
	
	@ResponseBody
	@RequestMapping(value = "/fe.do")
	private Map<String, String> fireExStatusUpdate(@ModelAttribute TbFireExVO fire,  @RequestParam("missing") String fire_ex_name) throws Exception{
		fire.setFire_ex_name(fire_ex_name);
		fire.setFire_ex_status("0");
		
		fService.fireExStatusUpdate(fire);
		System.out.println(fire_ex_name + "의 상태값이 변했습니다.");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Access", "ok");
		return map;
	}
	
	
}
