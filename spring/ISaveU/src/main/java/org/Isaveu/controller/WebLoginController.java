package org.Isaveu.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.HrService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class WebLoginController {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hrService;
	//	Session session;

	@RequestMapping(value = "/weblogin", method = RequestMethod.POST)
	private String webLogin(@ModelAttribute TbHrVO hrvo, HttpServletRequest request, HttpServletResponse response) throws Exception{
			if(request.getParameter("id") == null || request.getParameter("pw") == null || request.getParameter("id").equals("") || request.getParameter("pw").equals("pw")) {
				return "index";
			}else {
				return "admin";
			}
			
//			String id  = request.getParameter("id");
//			String pw  = request.getParameter("pw");
//			System.out.println(id);
//			System.out.println(pw);
			
//			ArrayList<TbHrVO> list = new ArrayList<TbHrVO>(); 
//			list = hrService.getHrListId(id);
//			TbHrVO result = list.get(0);
//			System.out.println("WebLogin Querry OK");

//			if(id.equals(result.getId()) && pw.equals(result.getPw())){
//				System.out.println("WebLogin Succes");
//				return "admin";
//			}else {
//				System.out.println("WebLogin Fail");
//				return "index";
//			}
//		}else {
//			return "index";
//		}
	}
}

