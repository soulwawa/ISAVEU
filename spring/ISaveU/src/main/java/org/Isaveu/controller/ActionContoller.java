package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.Isaveu.domain.LocationByIssueVO;
import org.Isaveu.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActionContoller {

	@Resource(name = "org.Isaveu.service.ActionService")
	ActionService aService;
	
	@ResponseBody
	@RequestMapping("/admin/event.do")
	public Map<String, Object>dispatcherEvent() throws Exception {
		ArrayList<LocationByIssueVO> list = new ArrayList<LocationByIssueVO>();
		list = aService.selectAllList();
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	
	
}
