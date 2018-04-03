package org.Isaveu.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.Isaveu.domain.ModuleByLocationVO;
import org.Isaveu.domain.TbActionVO;
import org.Isaveu.domain.TbEventVO;
import org.Isaveu.domain.TbHrVO;
import org.Isaveu.domain.TbModuleVO;
import org.Isaveu.mapper.ModuleMapper;
import org.Isaveu.service.ActionService;
import org.Isaveu.service.EventService;
import org.Isaveu.service.HrService;
import org.Isaveu.service.LocationService;
import org.Isaveu.util.Data;
import org.Isaveu.util.FCMData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class EventController {
	String issue; 
	float temp; 
	float smoke;
	float gyro;
	float fire;
	String module_id;
	Date date = new Date();
	SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	String datenow = transFomat.format(date);
	
	@Resource( name = "org.Isaveu.service.EventService")
	EventService eService;

	@Resource (name = "org.Isaveu.service.ActionService")
	ActionService aService;

	@Resource (name = "org.Isaveu.service.HrService")
	HrService hService;
	
	@Resource (name = "org.Isaveu.service.LocationService")
	LocationService lService;
	
	@Resource (name = "org.Isaveu.service.ModuleService")
	ModuleMapper mService;
	
	@RequestMapping(value = "/eventIn.do", method = RequestMethod.GET)
	private String eventIn(@ModelAttribute TbEventVO event) throws Exception{
		issue = event.getIssue();
		temp = event.getTemp(); 
		smoke = event.getSmoke();
		gyro = event.getGyro();
		fire = event.getFire();
		module_id = event.getModule_id();
		
		//if 모듈이 여러개일때 가정
		String typeArduino = "arduino"; 
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		
		switch (issue) {
		case "1":
			System.out.println("화재경보| " + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			break;
		case "2":
			System.out.println("지진경보: "  + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			break;
		case "3":
			System.out.println("지진 + 화재경보| "  + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			break;
		case "0":
			System.out.println("센서상태 양호| " + datenow);
			for(int i =0 ; i < moduleList.size() ; i++) {
				float ramdom = (float) Math.random();
				event.setModule_id(String.valueOf(i));
				event.setTemp(temp + ramdom);
				event.setSmoke(smoke + ramdom);
				event.setGyro(gyro + ramdom);
				event.setFire(fire + ramdom);
				event.setIssue(issue);
				eService.insertEvent(event);
			}
		default:
//			eService.insertEvent(event);
			RaspControl(issue);
			System.out.println("InsertEvent Succes");
			break;
		}
		return "200".toString();
	}

	public void imageGet(String issue) {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("http://192.168.0.13:5001/cam/" +issue).build().toUri();
		byte[] response = new byte[8*1024];
		response = restTemplate.getForObject(uri, byte[].class);
//		Date date = new Date();
//		SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String fileName = transFomat.format(date);
		String localName = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\";
		String fileExtension = ".png"; 
		String androidPass = "http://192.168.0.35:9999/AndoridIamgeGet.do?imageID=";
		String serverName = localName + datenow + fileExtension;
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
//			System.out.println(serverName);
			action.setUrl(serverName);
			action.setModule_id(module_id);
			FcmSend(androidPass + datenow + fileExtension, issue);
			try {
				aService.insertAction(action);
				System.out.println("Rasp Send Succes");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void FcmSend(String fileName, String issue) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		//TITILE
		ArrayList<ModuleByLocationVO> localList = new ArrayList<ModuleByLocationVO>();
		try {
			localList = lService.moduleByLocation(module_id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(module_id);
		ModuleByLocationVO location = localList.get(0);
		String title = location.getLocation() + "/"+ location.getDept_name();
		
		//DATA
		headers.add("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
		ArrayList<TbHrVO> hrList = new ArrayList<TbHrVO>();
		try {
			hrList = hService.getHrAllList();
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
		data.setContent_1(fileName); //사진
		data.setContent_2(issue); //0 - 화재, 1 - 소화기
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);

		String params = gson.toJson(fcmData);
		System.out.println(params);

		HttpEntity request;
		request = new HttpEntity(params, headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST,request,String.class);
		System.out.println(result.getBody());
		RaspControl(issue);
	}

	public void RaspControl(String issue) {
		switch (issue) {
		case "1": case "2": case "3":
			issue = "1";
			break;
		default:
			issue = "0";
			break;
		} 
		String url = "http://192.168.0.61:5002/siren/" + issue;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);
	}


	@RequestMapping("/Dispatcher")
	private Map<String, Object> dispatcher(@ModelAttribute TbEventVO event) throws Exception{
	
		//이번에는 이전 예제와는 다르게 Ajax요청이 오면 응답해줄꺼다.
		//이전에는 그냥 내가 원하는 페이지로 json을 가져가는 거였다면?
		//지금은 요청한 놈한테 return만 해주면 되기 때문에
		//PrintWriter out = resp.getWriter();
		//이걸 사용하면 된다.
		//주소요청 http://localhost:8000/JsonAjax/Dispatcher
		//Get방식
		//process()함수 호출
		//JSON만들기
//		JsonObject jsonObj = new JsonObject();
//
//		Date date = new Date();
//		SimpleDateFormat transFomat2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String datenow = transFomat2.format(date);
//		jsonObj.addProperty("temp", temp);
//		jsonObj.addProperty("smoke", smoke);
//		jsonObj.addProperty("fire", fire);
//		jsonObj.addProperty("gyro", gyro);
//		jsonObj.addProperty("date", datenow);
//		jsonObj.addProperty("msg", "success");
//		PrintWriter out = resp.getWriter();
//		out.print(jsonObj);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", temp);
		map.put("smoke", (smoke/10f));
		map.put("fire", 120-(fire/10f));
		map.put("gyro", 120-(gyro/10f));
		map.put("date", datenow);
		return map;		
	}
	@RequestMapping("/DispatcherRecent")
	private List<Map<String, Object>> dispatcherRecent(@ModelAttribute TbEventVO event, @RequestParam("num") int num) throws Exception{
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();
		list = eService.selectRecent(num);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();

		for(int i = 0 ; i < list.size() ; i++ ) {
			map = new LinkedHashMap();
			map.put("time", list.get(i).getTime().substring(11,19));
			map.put("temp", list.get(i).getTemp());
			map.put("smoke", (list.get(i).getSmoke()/10f));
			map.put("fire", (1050-list.get(i).getFire())/10f);
			map.put("gyro", (1050-list.get(i).getGyro())/10f);
			myList.add(i, map);
		}
		return myList;
	}

}
