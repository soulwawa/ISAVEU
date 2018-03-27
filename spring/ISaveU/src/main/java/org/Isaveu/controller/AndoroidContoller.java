package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.HrService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@Controller
public class AndoroidContoller {
	SqlSession sqlSession = null;
	
	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;

	@ResponseBody
	@RequestMapping(value = "/AndroidLogin.do")
	private Map<String, String> androidLogin(@ModelAttribute TbHrVO hrvo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("u_id");
		String andPw = request.getParameter("u_pw");
		String fcmValue = request.getParameter("u_instancekey");
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println(andId);
		ArrayList<TbHrVO> list = new ArrayList<TbHrVO>(); 
		list = hService.getHrListId(andId);
		System.out.println(list.size());
		
		JsonObject loginOk = new JsonObject();
		String resultJson;
		if(list.size() == 0) { 
			System.out.println("Android Login Query FAIL");
			map.put("access", "0");
			map.put("name", "0");
			map.put("profile", "0");
			map.put("email", "0");
			
//			loginOk.addProperty("access", "0");
//			loginOk.addProperty("name", "0");
//			loginOk.addProperty("profile", "0");
//			loginOk.addProperty("email", "0");
//			resultJson = loginOk.toString();
//			request.setAttribute("resultJson", resultJson);
//			request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
		}else {
			TbHrVO result = list.get(0);
			System.out.println("Android Login Query SUCCESS");
			if(andId.equals(result.getId()) && andPw.equals(result.getPw())) {
				if(!(fcmValue.equals(result.getFcm()))) {
					System.out.println("FCM UPDATE");
					hrvo.setFcm(fcmValue);
					hrvo.setId(andId);
					hService.fcmUpdate(hrvo);
					map.put("access", "1");
					map.put("name", result.getName().toString());
					map.put("profile", result.getProfile().toString());
					map.put("email", result.getEmail().toString());
					map.put("fcm", result.getFcm().toString());
					
//					loginOk.addProperty("access", "1");
//					loginOk.addProperty("name", result.getName().toString());				
//					loginOk.addProperty("profile", result.getProfile().toString());
//					loginOk.addProperty("email", result.getEmail().toString());
//					loginOk.addProperty("fcm", result.getFcm().toString());
//					resultJson = loginOk.toString();
//					request.setAttribute("resultJson", resultJson);
//					request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
				}else {
					System.out.println("FCM EQUALS");
					map.put("access", "1");
					map.put("name", result.getName().toString());
					map.put("profile", result.getProfile().toString());
					map.put("email", result.getEmail().toString());
					map.put("fcm", result.getFcm().toString());
//					loginOk.addProperty("access", "1");
//					loginOk.addProperty("name", result.getName().toString());				
//					loginOk.addProperty("profile", result.getProfile().toString());
//					loginOk.addProperty("email", result.getEmail().toString());
//					loginOk.addProperty("fcm", result.getFcm().toString());
//					resultJson = loginOk.toString();
//					request.setAttribute("resultJson", resultJson);
//					request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
				}
			}else {
				System.out.println("Login FAIL");
				map.put("access", "0");
				map.put("name", "0");
				map.put("profile", "0");
				map.put("email", "0");
//				loginOk.addProperty("access", "0");
//				loginOk.addProperty("name", "0");
//				loginOk.addProperty("profile", "0");
//				loginOk.addProperty("email", "0");
//				resultJson = loginOk.toString();
//				request.setAttribute("resultJson", resultJson);
//				request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
			}
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/AndroidStreaming.do")
	public Map<String, String> AndroidStreming(HttpServletRequest request){
		String act_st = request.getParameter("act_st");
//		System.out.println(act_st);
		Map<String, String> map = new HashMap<String, String>();
		
		if (act_st.equals("1")) {
			map.put("streaming_access","http://192.168.0.13:5001/stream/1/" );
			map.put("streamingServer_url","http://192.168.0.13:5000/video_stream" );
		}else {
			map.put("streaming_access","http://192.168.0.13:5001/stream/0/" );
			map.put("streamingServer_url","http://192.168.0.13:5000/video_stream" );
		}
		return map;
	}
}

