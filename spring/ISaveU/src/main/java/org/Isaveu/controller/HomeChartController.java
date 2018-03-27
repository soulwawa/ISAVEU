package org.Isaveu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeChartController {
	
	@ResponseBody
	@RequestMapping(value = "/chart.do", produces = "application/json")
	private void ChartValue() throws Exception{
		
	}
}
