package org.Isaveu.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.domain.TbFireExVO;
import org.Isaveu.domain.TbHrVO;
import org.Isaveu.fcm.Data;
import org.Isaveu.fcm.FCMData;
import org.Isaveu.service.FireExService;
import org.Isaveu.service.HrService;
import org.Isaveu.service.LocationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Controller
@RequestMapping("/module/*")
public class FireExController {
	
	@Resource(name = "org.Isave.service.FireExService")
	FireExService fService;
	
	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;
	
	@Resource (name = "org.Isaveu.service.LocationService")
	LocationService lService;
	
	
	@ResponseBody
	@RequestMapping(value = "/fe.do")
	//라즈베리에서 INPUT
	private Map<String, String> fireExStatusUpdate(@ModelAttribute TbFireExVO fire,  @RequestParam("missing") String fire_ex_name) throws Exception{
		
		fire.setFire_ex_name(fire_ex_name);
		fire.setFire_ex_status("0");
		
		fService.fireExStatusUpdate(fire);
		System.out.println(fire_ex_name + "의 상태값이 변했습니다.");
		
		ArrayList<TbFireExVO> hrlist = new ArrayList<TbFireExVO>();
		hrlist = fService.getFireEx(fire_ex_name);
		TbFireExVO fireVo = hrlist.get(0);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		//TITILE
		ArrayList<LocationByFireExVO> localList = new ArrayList<LocationByFireExVO>();
		
		
		localList = lService.locationByFireExName(fire_ex_name);
		
		LocationByFireExVO location = localList.get(0);
		String title = location.getLocation() + "/"+ location.getDept_name();
		
		//DATA
		headers.add("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
		ArrayList<TbHrVO> hrList = new ArrayList<TbHrVO>();
		try {
			hrList = hService.getHrListLevel("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<String> fcmList = new ArrayList<String>();
		
		for (TbHrVO tbHrVO : hrList) {
			fcmList.add(tbHrVO.getFcm());
		}
		Gson gson = new Gson();
		JsonElement reglist = gson.toJsonTree(fcmList);
		String url = "https://fcm.googleapis.com/fcm/send"; 
		FCMData fcmData = new FCMData();
		Data data = new Data();
		// DB에서 호출 예정
		
		data.setTitle(title);
		data.setContent_1(fire_ex_name + " 소화기가 분실되었습니다."); //사진
		data.setContent_2("4"); //소화기 분실 임시지정 
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);

		String params = gson.toJson(fcmData);
		System.out.println(params);

		HttpEntity request;
		request = new HttpEntity(params, headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST,request,String.class);
		System.out.println(result.getBody());
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("Access", "ok");
		return map;
	}
	
	

	
	
}
