package org.Isaveu.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.Isaveu.domain.TbActionVO;
import org.Isaveu.domain.TbEventVO;
import org.Isaveu.domain.TbHrVO;
import org.Isaveu.service.ActionService;
import org.Isaveu.service.EventService;
import org.Isaveu.service.HrService;
import org.Isaveu.util.Data;
import org.Isaveu.util.FCMData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

@RestController
public class EventController {

	@Resource( name = "org.Isaveu.service.EventService")
	EventService eService;
	
	@Resource (name = "org.Isaveu.service.ActionService")
	ActionService aService;
	
	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;
	
	@RequestMapping(value = "/eventIn.do", method = RequestMethod.GET)
	private TbEventVO eventIn(@ModelAttribute TbEventVO event, Model model) throws Exception{
		String issue = event.getIssue();
//		model.addAllAttributes(hService.getHrAllList());
		switch (issue) {
		case "1":
			System.out.println("화재경보");
			imageGet(issue, model);
			break;
		case "2":
			System.out.println("지진경보");
			imageGet(issue, model);
			break;
		case "3":
			System.out.println("지진 + 화재경보");
			imageGet(issue, model);
			break;
		default:
			eService.insertEvent(event);
			System.out.println("InsertEvent Succes");
			break;
		}
		return event;
	}
	
	public void imageGet(String issue, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("http://192.168.0.13:5001/cam/" +issue).build().toUri();
		byte[] response = new byte[8*1024];
		response = restTemplate.getForObject(uri, byte[].class);
		Date date = new Date();
		SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String fileName = transFomat.format(date);
		String localName = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\";
		String fileExtension = ".png"; 
		String androidPass = "http://192.168.0.35:8080/AndoridIamgeGet.do?imageID=";
		String serverName = localName + fileName + fileExtension;
		//C:\workspace\SaveForYou\spring\ISaveU\src\main\resources\eventImage
		File imageFile = new File(serverName);
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile));
			os.write(response);
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			TbActionVO action = new TbActionVO();
			System.out.println(serverName);
			action.setUrl(serverName);
			FcmSend(androidPass + fileName + fileExtension);
			try {
				aService.insertAction(action);
				System.out.println("Rasp Send Succes");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void FcmSend(String fileName) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.add("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
		ArrayList<TbHrVO> arrayList = new ArrayList<TbHrVO>();
		try {
			arrayList = hService.getHrAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> fcmList = new ArrayList<String>();
		for (TbHrVO tbHrVO : arrayList) {
			fcmList.add(tbHrVO.getFcm());
		}
		Gson gson = new Gson();
		JsonElement reglist = gson.toJsonTree(fcmList);
		String url = "https://fcm.googleapis.com/fcm/send"; 
		FCMData fcmData = new FCMData();
		Data data = new Data();
		data.setTitle("[I Save You]긴급상황 발생");
		data.setContent_1(fileName);
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