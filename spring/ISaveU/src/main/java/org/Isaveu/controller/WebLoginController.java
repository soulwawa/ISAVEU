package org.Isaveu.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.HrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebLoginController {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hrService;
	//	Session session;

	@RequestMapping("/weblogin")
	private String webLogin(@ModelAttribute TbHrVO hrvo, @RequestParam("id") String id, @RequestParam("pw") String pw ) throws Exception{
		if("".equals(id) || "".equals(pw)){
			return "redirect:/";
		}else {
//			System.out.println(id);
//			System.out.println(pw);
			ArrayList<TbHrVO> list = new ArrayList<TbHrVO>(); 
			list = hrService.getHrListId(id);
			TbHrVO result = list.get(0);
			System.out.println("WebLogin Querry OK");
			if(id.equals(result.getId()) && pw.equals(result.getPw())){
				System.out.println("WebLogin Succes");
				return "admin";
			}else {
				System.out.println("WebLogin Fail");
				return "redirect:/";
			}
		}	
	}
}

