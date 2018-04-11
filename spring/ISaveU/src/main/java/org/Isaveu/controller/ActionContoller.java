package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.Isaveu.domain.ActionBoardVO;
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
		System.out.println("Request /admin/event.do");
		ArrayList<ActionBoardVO> list = new ArrayList<ActionBoardVO>();
		list = aService.selectAllList();
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	
	
}
