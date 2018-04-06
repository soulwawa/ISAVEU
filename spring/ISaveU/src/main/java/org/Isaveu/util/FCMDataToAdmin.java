package org.Isaveu.util;

import java.nio.charset.Charset;
import java.util.ArrayList;

import org.Isaveu.domain.ModuleByLocationVO;
import org.Isaveu.domain.TbHrVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class FCMDataToAdmin {
	
	public void fCMSendToAdmin() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		//TITILE
		ArrayList<ModuleByLocationVO> localList = new ArrayList<ModuleByLocationVO>();
		
//		String module_id = String.valueOf(fireVo.getLocation_id());
//		try {
//			localList = lService.moduleByLocation(module_id);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		ModuleByLocationVO location = localList.get(0);
		String title = location.getLocation() + "/"+ location.getDept_name();
		
		//DATA
		headers.add("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
		ArrayList<TbHrVO> hrList = new ArrayList<TbHrVO>();
//		try {
//			hrList = hService.getHrListLevel("0");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
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
		data.setContent_1(" 소화기가 분실되었습니다."); //사진
		data.setContent_2("4"); //소화기 분실 임시지정 
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);

		String params = gson.toJson(fcmData);
		System.out.println(params);

		HttpEntity request;
		request = new HttpEntity(params, headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST,request,String.class);
		System.out.println(result.getBody());
	}
	
}

