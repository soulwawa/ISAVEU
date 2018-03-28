package org.Isaveu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FireExController {
	
	@ResponseBody
	@RequestMapping(value = "/fe.do")
	private Map<String, String> androidLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/plain;charset=utf-8");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Access", "a");
		return map;
	}
}
