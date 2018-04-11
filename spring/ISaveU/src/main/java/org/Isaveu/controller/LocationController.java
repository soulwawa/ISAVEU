package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
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
	public Map<String, Object> locationFireEx(@ModelAttribute LocationByFireExVO location,
			@RequestParam("loc") String loc) throws Exception {
		System.out.println("/admin/locationFireEx.do");
		ArrayList<LocationByFireExVO> list = new ArrayList<LocationByFireExVO>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = lService.locationByFireEx();
		map.put("floor", loc);
		map.put("value", list);

		return map;
	}
}
