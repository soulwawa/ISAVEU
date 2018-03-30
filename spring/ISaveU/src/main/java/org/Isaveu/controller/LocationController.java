package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController {

	@Resource(name = "org.Isaveu.service.LocationService")
	LocationService lService;

	@ResponseBody
	@RequestMapping(value = "/locationFireEx.do")
	public Map<String, String> locationFireEx(@ModelAttribute LocationByFireExVO location, HttpServletResponse response) throws Exception{

		response.setContentType("text/plain;charset=utf-8");
		ArrayList<LocationByFireExVO> list = new ArrayList<LocationByFireExVO>();
		list = lService.locationByFireEx();
		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0 ; i < list.size() ; i++) {
			map.put(list.get(i).getLocation(), list.get(i).getFire_ex_status());
		}
		return map;

	}
}
