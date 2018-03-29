package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.HrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AndoroidContoller {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;

	@ResponseBody
	@RequestMapping(value = "/AndroidLogin.do")
	public Map<String, String> androidLogin(@ModelAttribute TbHrVO hrvo, @RequestParam("u_id") String id, @RequestParam("u_pw") String pw, @RequestParam("u_instancekey") String fcm) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		
		if("".equals(id) || "".equals(pw)){
			System.out.println("WebLogin Fail");
			map.put("access", "0");
			map.put("name", "0");
			map.put("profile", "0");
			map.put("email", "0");
			return map;
		}else {
			ArrayList<TbHrVO> list = new ArrayList<TbHrVO>();
			list = hService.getHrListId(id);
			TbHrVO result = list.get(0);
			System.out.println("Android Login Query SUCCESS");
			System.out.println(fcm);
			if(id.equals(result.getId()) && pw.equals(result.getPw())) {
				if(!(fcm.equals(result.getFcm()) || (!"".equals(fcm)) )) {
					System.out.println("FCM UPDATE");
					hrvo.setFcm(fcm);
					hService.fcmUpdate(id);
					map.put("access", "1");
					map.put("name", result.getName().toString());
					map.put("profile", result.getProfile().toString());
					map.put("email", result.getEmail().toString());
					map.put("fcm", result.getFcm().toString());
					return map;
				}else {
					System.out.println("FCM EQUALS");
					map.put("access", "1");
					map.put("name", result.getName().toString());
					map.put("profile", result.getProfile().toString());
					map.put("email", result.getEmail().toString());
					map.put("fcm", result.getFcm().toString());
					return map;
				}
			}else{
				System.out.println("Login FAIL");
				map.put("access", "0");
				map.put("name", "0");
				map.put("profile", "0");
				map.put("email", "0");
				return map;
			}		
		}
	}	
	@ResponseBody
	@RequestMapping(value = "/AndroidStreaming.do")
	public Map<String, String> AndroidStreming(HttpServletRequest request){
		String act_st = request.getParameter("act_st");
		Map<String, String> map = new HashMap<String, String>();

		if (act_st.equals("1")) {
			map.put("streamingServer_url","http://192.168.0.13:5001/stream/1/" );
			map.put("streaming_access","http://192.168.0.13:5000/video_stream" );
		}else {
			map.put("streamingServer_url","http://192.168.0.13:5001/stream/0/" );
			map.put("streaming_access","http://192.168.0.13:5000/video_stream" );
		}
		return map;
	}
}

