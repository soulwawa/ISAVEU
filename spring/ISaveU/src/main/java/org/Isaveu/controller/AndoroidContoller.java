package org.Isaveu.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.HrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@Controller
public class AndoroidContoller {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;

	@ResponseBody
	@RequestMapping(value = "/AndroidLogin.do",  method = RequestMethod.POST)
	private void androidLogin(@ModelAttribute TbHrVO hrvo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("u_id");
		String andPw = request.getParameter("u_pw");
		String fcmValue = request.getParameter("u_instancekey");
		
		System.out.println(andId);
		ArrayList<TbHrVO> list = new ArrayList<TbHrVO>();
		hService.getHrListId(andId);
		System.out.println(list.get(0));
	}
	}
		
//		System.out.println(list.toString());
//		JsonObject loginOk = new JsonObject();
//		String resultJson;
//		if(list.size() == 0) { 
//			System.out.println("Android Login Query FAIL");
//			loginOk.addProperty("access", "0");
//			loginOk.addProperty("name", "0");
//			loginOk.addProperty("profile", "0");
//			loginOk.addProperty("email", "0");
//			resultJson = loginOk.toString();
////			request.setAttribute("resultJson", resultJson);
////			request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
//		}else {
//			TbHrVO result = list.get(0);
//			System.out.println("Android Login Query SUCCESS");
//			if(andId.equals(result.getId()) && andPw.equals(result.getPw())) {
//				if(!(fcmValue.equals(result.getFcm()))) {
//					System.out.println("FCM UPDATE");
//					hrvo.setFcm(fcmValue);
//					hrvo.setId(andId);
//					hService.fcmUpdate(hrvo);
//					loginOk.addProperty("access", "1");
//					loginOk.addProperty("name", result.getName().toString());				
//					loginOk.addProperty("profile", result.getProfile().toString());
//					loginOk.addProperty("email", result.getEmail().toString());
//					loginOk.addProperty("fcm", result.getFcm().toString());
//					resultJson = loginOk.toString();
////					request.setAttribute("resultJson", resultJson);
////					request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
//				}else {
//					System.out.println("FCM EQUALS");
//					loginOk.addProperty("access", "1");
//					loginOk.addProperty("name", result.getName().toString());				
//					loginOk.addProperty("profile", result.getProfile().toString());
//					loginOk.addProperty("email", result.getEmail().toString());
//					loginOk.addProperty("fcm", result.getFcm().toString());
//					resultJson = loginOk.toString();
////					request.setAttribute("resultJson", resultJson);
////					request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
//				}
//			}else {
//				System.out.println("Login FAIL");
//				loginOk.addProperty("access", "0");
//				loginOk.addProperty("name", "0");
//				loginOk.addProperty("profile", "0");
//				loginOk.addProperty("email", "0");
//				resultJson = loginOk.toString();
////				request.setAttribute("resultJson", resultJson);
////				request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
//			}
//		}
//		return resultJson;
//	}


