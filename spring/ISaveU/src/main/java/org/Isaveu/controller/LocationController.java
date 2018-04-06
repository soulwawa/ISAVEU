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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController {

	@Resource(name = "org.Isaveu.service.LocationService")
	LocationService lService;

	@ResponseBody
	@RequestMapping(value = "/admin/locationFireEx.do")
	public Map<String, Object> locationFireEx(@ModelAttribute LocationByFireExVO location, @RequestParam("loc") String loc) throws Exception{

		ArrayList<LocationByFireExVO> list = new ArrayList<LocationByFireExVO>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		list = lService.locationByFireEx();
		map.put("floor", loc);
		map.put("list", list);
		
//		for (int i = 0 ; i < list.size() ; i++) {
//			map.put(list.get(i).getLocation(), list.get(i).getFire_ex_status());
//		}
		return map;
	}
//	@ResponseBody
//	@RequestMapping(value = "/locationFireExDate.do")
//	public Map<String, String> locationFireExdate(@ModelAttribute LocationByFireExVO location, @RequestParam("loc") String loc) throws Exception{
//
//		ArrayList<LocationByFireExVO> list = new ArrayList<LocationByFireExVO>();
//		list = lService.locationByFireEx();
//		Map<String, String> map = new HashMap<String, String>();
//
//		for (int i = 0 ; i < list.size() ; i++) {
//			map.put(list.get(i).getLocation(), list.get(i).getCheck_date().substring(0,10));
//		}
//		return map;
//
//	}
}
