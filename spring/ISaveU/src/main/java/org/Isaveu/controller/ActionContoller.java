package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.Isaveu.domain.TbActionVO;
import org.Isaveu.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActionContoller {

	@Resource(name = "org.Isave.service.ActionService")
	ActionService aService;
	
	@ResponseBody
	@RequestMapping("/admin/event,do")
	public List<Map<String, Object>> dispatcherEvent(@ModelAttribute TbActionVO action) throws Exception {
		ArrayList<TbActionVO> list = new ArrayList<TbActionVO>();
		list = aService.selectAllList();
		Map<String, Object> map =  new HashMap<String, Object>();
		
		return null;
	}
	
	
	
}
