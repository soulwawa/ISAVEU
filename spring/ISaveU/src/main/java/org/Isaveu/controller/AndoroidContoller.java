package org.Isaveu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.domain.LocationByIssueVO;
import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.FireExService;
import org.Isaveu.service.HrService;
import org.Isaveu.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/Android/*")
public class AndoroidContoller {

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;

	@Resource(name = "org.Isaveu.service.LocationService")
	LocationService lService;
	
	@Resource(name = "org.Isave.service.FireExService")
	FireExService fService;
	
	@ResponseBody
	@RequestMapping(value = "/Login.do")
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
			if(list.size() != 0) {
				hrvo = list.get(0);
				System.out.println("Android Login Query SUCCESS");
//				System.out.println(fcm);
				if(id.equals(hrvo.getId()) && pw.equals(hrvo.getPw())) {
					if(fcm.equals(hrvo.getFcm())) {
						System.out.println("FCM EQUALS");
						map.put("access", "1");
						map.put("name", hrvo.getName().toString());
						map.put("profile", hrvo.getProfile().toString());
						map.put("email", hrvo.getEmail().toString());
						map.put("fcm", hrvo.getFcm().toString());
						return map;
					}else {
						System.out.println("FCM UPDATE");
//						System.out.println(hrvo.getFcm());
						System.out.println(fcm);
						hrvo.setFcm(fcm);
						hService.fcmUpdate(hrvo);
						map.put("access", "1");
						map.put("name", hrvo.getName().toString());
						map.put("profile", hrvo.getProfile().toString());
						map.put("email", hrvo.getEmail().toString());
						map.put("fcm", hrvo.getFcm().toString());
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
			}else {
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
	@RequestMapping(value = "/Streaming.do")
	public Map<String, String> AndroidStreming(@RequestParam("act_st") String act_st){
//		act_st = request.getParameter("act_st");
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
	
	@ResponseBody
	@RequestMapping(value = "/DisasterCheck.do")
	public Map<String, Object> AndroiDisasterCheck(@RequestParam("loc") String loc){
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println(loc);
		String count = "";
		try {
			count = lService.locationCount(loc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<LocationByIssueVO> list = new ArrayList<LocationByIssueVO>();
		try {
			list = lService.AndroidDisasterCheck(Integer.parseInt(count));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		ArrayList<LocationByIssueVO> listMap=  new ArrayList<LocationByIssueVO>();
//		for(int i = 0 ; i < list.size() ; i++) {
//			listMap.add(list.get(i));
//		}
		map.put("floor", loc);
		map.put("list", list);
		System.out.println(map);
		return map;
		
	}
	@ResponseBody
	@RequestMapping(value = "/feRestart.do")
	public Map<String, String> AndroidfeRestart(@RequestParam("loc") String loc){
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println(loc);
		String url = "http://192.168.0.61:5002/feRestart/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);
		
		try {
			fService.updatefireExStatus(loc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("access", "ok");
		return map;
	}
	
	
}

