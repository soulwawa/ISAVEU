package org.Isaveu.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.dto.LoginDTO;
import org.Isaveu.service.HrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebLoginController {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hrService;
	//	Session session;

	@RequestMapping(value = "/weblogin", method = RequestMethod.POST)
	private void webLogin(LoginDTO dto, HttpSession session, Model model) throws Exception{
		TbHrVO vo = hrService.login(dto);
		if(vo == null) {
			return;
		}
		
		model.addAttribute("tbHrVO", vo);
		
//		if("".equals(id) || "".equals(pw)){
//			System.out.println("WebLogin Fail");
//			return "redirect:/";
//		}else {
//			ArrayList<TbHrVO> list = new ArrayList<TbHrVO>(); 
//			list = hrService.getHrListId(id);
//			if(list.size() == 0) {
//				return "redirect:/";
//			}else {
//				TbHrVO result = list.get(0);
//				System.out.println("WebLogin Querry OK");
//				if(id.equals(result.getId()) && pw.equals(result.getPw())){
//					System.out.println("WebLogin Succes");
//					return "admin";
//				}else {
//					System.out.println("WebLogin Fail");
//					return "redirect:/";
//				}
//			}
//		}	
	}
}

