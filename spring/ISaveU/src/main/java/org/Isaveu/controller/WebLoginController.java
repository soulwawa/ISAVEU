package org.Isaveu.controller;


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

@Controller
@RequestMapping("/user")
public class WebLoginController {

	@Resource(name = "org.Isaveu.service.HrService")
	HrService hrService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		System.out.println("/user/login");
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	private void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		System.out.println("/user/loginPost");
		TbHrVO vo = hrService.login(dto);
		if (vo == null) {
			return;
		}

		model.addAttribute("tbHrVO", vo);
		
	}
}
