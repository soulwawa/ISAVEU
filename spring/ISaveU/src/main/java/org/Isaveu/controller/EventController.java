package org.Isaveu.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class EventController {
	String issue;
	String issueTemp = "0";
	float temp;
	float smoke;
	float gyro;
	float fire;
	String module_id;
	Date date = new Date();
	SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	String datenow = transFomat.format(date);
	String typeArduino = "arduino";
	DecimalFormat form = new DecimalFormat("#.##");

	@Resource(name = "org.Isaveu.service.EventService")
	EventService eService;

	@Resource(name = "org.Isaveu.service.ActionService")
	ActionService aService;

	@Resource(name = "org.Isaveu.service.HrService")
	HrService hService;

	@Resource(name = "org.Isaveu.service.LocationService")
	LocationService lService;

	@Resource(name = "org.Isaveu.service.ModuleService")
	ModuleMapper mService;

	@RequestMapping(value = "/module/eventIn.do", method = RequestMethod.GET)
	private String eventIn(@ModelAttribute TbEventVO event) throws Exception {
		issue = event.getIssue();
		temp = event.getTemp();
		smoke = event.getSmoke();
		gyro = event.getGyro();
		fire = event.getFire();
		module_id = event.getModule_id();
		

		// if 모듈이 여러개일때 가정
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);

		switch (issue) {
		case "1":
			System.out.println("화재경보| " + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("InsertEvent Succes");
			break;
		case "2":
			System.out.println("지진경보: " + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("InsertEvent Succes");
			break;
		case "3":
			System.out.println("지진 + 화재경보| " + datenow);
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("InsertEvent Succes");
			break;
		default:
			if(issue.equals(issueTemp)) {
				issueTemp = issue;
				System.out.println("module_id: " + module_id);
				System.out.println("issue: " + issue + "issueTemp" + issueTemp);
				System.out.println("센서상태 양호| " + datenow);
				if (module_id.equals("0")) {
					for (int i = 0; i < moduleList.size(); i++) {
						float ramdom = (float) Math.random();
						event.setModule_id(String.valueOf(i));
						event.setTemp(temp + ramdom);
						event.setSmoke(smoke + ramdom);
						event.setGyro(gyro + ramdom);
						event.setFire(fire + ramdom);
						event.setIssue(issue);
						eService.insertEvent(event);
						// System.out.println("InsertEvent Succes");
					}
				} else {
					for (int i = 0; i < moduleList.size(); i++) {
						if (i == Integer.parseInt(module_id)) {
							continue;
						} else {
							float ramdom = (float) Math.random();
							event.setModule_id(String.valueOf(i));
							event.setTemp(temp + ramdom);
							event.setSmoke(smoke + ramdom);
							event.setGyro(gyro + ramdom);
							event.setFire(fire + ramdom);
							event.setIssue(issue);
							eService.insertEvent(event);
							// System.out.println("InsertEvent Succes");
						}
					}
				}
			}else {
				System.out.println("센서 오류 감지 :" + module_id);
				
			}
			
			RaspControl(issue);
			break;
		}
		return "200".toString();
	}

	public void imageGet(String issue) {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("http://192.168.0.13:5001/cam/" + issue).build().toUri();
		byte[] response = new byte[8 * 1024];
		response = restTemplate.getForObject(uri, byte[].class);
		// Date date = new Date();
		// SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		// String fileName = transFomat.format(date);
		String localName = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\";
		String fileExtension = ".png";
		String androidPass = "http://192.168.0.35:9999/Android/IamgeGet.do?imageID=";
		String serverName = localName + datenow + fileExtension;
		// C:\workspace\SaveForYou\spring\ISaveU\src\main\resources\eventImage
		File imageFile = new File(serverName);
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile));
			os.write(response);
			os.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			TbActionVO action = new TbActionVO();
			// System.out.println(serverName);
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
		// TITILE
		ArrayList<ModuleByLocationVO> localList = new ArrayList<ModuleByLocationVO>();
		try {
			localList = lService.moduleByLocation(module_id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(module_id);
		ModuleByLocationVO location = localList.get(0);
		String title = location.getLocation() + "/" + location.getDept_name();

		// DATA
		headers.add("Authorization",
				"key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
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
		data.setContent_1(fileName); // 사진
		data.setContent_2(issue); // 0 - 화재, 1 - 소화기
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);

		String params = gson.toJson(fcmData);
		System.out.println(params);

		HttpEntity request;
		request = new HttpEntity(params, headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
		System.out.println(result.getBody());
		RaspControl(issue);
	}

	public void RaspControl(String issue) {
		switch (issue) {
		case "1":
		case "2":
		case "3":
			issue = "1";
			break;
		default:
			issue = "0";
			break;
		}
		String urlArray[] = { "13:5001", "61:5002" };
		for (int i = 0; i < urlArray.length; i++) {
			String url = "http://192.168.0." + urlArray[i] + "/siren/" + issue;
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			System.out.println(result);
		}

	}

	@RequestMapping("/admin/Dispatcher")
	private Map<String, Object> dispatcher(@ModelAttribute TbEventVO event) throws Exception {

		// 이번에는 이전 예제와는 다르게 Ajax요청이 오면 응답해줄꺼다.
		// 이전에는 그냥 내가 원하는 페이지로 json을 가져가는 거였다면?
		// 지금은 요청한 놈한테 return만 해주면 되기 때문에
		// PrintWriter out = resp.getWriter();
		// 이걸 사용하면 된다.
		// 주소요청 http://localhost:8000/JsonAjax/Dispatcher
		// Get방식
		// process()함수 호출
		// JSON만들기
		// JsonObject jsonObj = new JsonObject();
		//
		// Date date = new Date();
		// SimpleDateFormat transFomat2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		// String datenow = transFomat2.format(date);
		// jsonObj.addProperty("temp", temp);
		// jsonObj.addProperty("smoke", smoke);
		// jsonObj.addProperty("fire", fire);
		// jsonObj.addProperty("gyro", gyro);
		// jsonObj.addProperty("date", datenow);
		// jsonObj.addProperty("msg", "success");
		// PrintWriter out = resp.getWriter();
		// out.print(jsonObj);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", form.format(temp));
		map.put("smoke", form.format((smoke / 20.0)));
		map.put("fire", form.format(80 - (fire / 13.0)));
		map.put("gyro", form.format(80 - (gyro / 13.0)));
		map.put("date", datenow);
		return map;
	}

	@RequestMapping("/admin/DispatcherRecent")
	private List<Map<String, Object>> dispatcherRecent(@ModelAttribute TbEventVO event, @RequestParam("num") int num)
			throws Exception {
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();
		list = eService.selectRecent(num);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();
		// System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			map.put("time", list.get(i).getTime().substring(11, 19));
			map.put("temp", form.format(list.get(i).getTemp()));
			map.put("smoke", form.format((list.get(i).getSmoke() / 20.0)));
			map.put("fire", form.format((80 - (list.get(i).getFire() / 13.0))));
			map.put("gyro", form.format((80 - (list.get(i).getGyro() / 13.0))));
			myList.add(i, map);
			// System.out.println(myList.toString());
		}
		Collections.reverse(myList);
		return myList;
	}

	@RequestMapping("/admin/DispatcherPart/temp")
	private List<Map<String, Object>> dispatcherPartTemp(@ModelAttribute TbEventVO event) throws Exception {
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());
		// System.out.println(list.size());
//		result = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			// System.out.println(i);
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				// map = new LinkedHashMap<String, Object>();
				// System.out.println(j);
				if (j % moduleList.size() == 0) {
					// System.out.println(j);
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), form.format(listDetail.getTemp()));
					// System.out.println(map.toString());
				} else {
					// System.out.println(j);
					map.put(listDetail.getModule_id(), form.format(listDetail.getTemp()));
					// System.out.println(map.toString());
				}
			}
			result.add(map);
			// Collections.reverse(result);
		}
		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/smoke")
	private List<Map<String, Object>> dispatcherPartSmoke(@ModelAttribute TbEventVO event) throws Exception {
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());
		// System.out.println(list.size());
//		result = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			// System.out.println(i);
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				// map = new LinkedHashMap<String, Object>();
				// System.out.println(j);
				if (j % moduleList.size() == 0) {
					// System.out.println(j);
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), form.format((listDetail.getSmoke() / 20.0)));
					// System.out.println(map.toString());
				} else {
					// System.out.println(j);
					map.put(listDetail.getModule_id(), form.format((listDetail.getSmoke() / 20.0)));
					// System.out.println(map.toString());
				}
			}
			result.add(map);
			// Collections.reverse(result);
		}
		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/fire")
	private List<Map<String, Object>> dispatcherPartFire(@ModelAttribute TbEventVO event) throws Exception {
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());
		// System.out.println(list.size());
//		result = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			// System.out.println(i);
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				// map = new LinkedHashMap<String, Object>();
				// System.out.println(j);
				if (j % moduleList.size() == 0) {
					// System.out.println(j);
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), form.format(80 - (listDetail.getFire() / 13.0)));
					// System.out.println(map.toString());
				} else {
					// System.out.println(j);
					map.put(listDetail.getModule_id(), form.format(80 - (listDetail.getFire() / 13.0)));
					// System.out.println(map.toString());
				}
			}
			result.add(map);
			// Collections.reverse(result);
		}
		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/gyro")
	private List<Map<String, Object>> dispatcherPartGyro(@ModelAttribute TbEventVO event) throws Exception {
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());
		// System.out.println(list.size());
//		result = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			// System.out.println(i);
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				// map = new LinkedHashMap<String, Object>();
				// System.out.println(j);
				if (j % moduleList.size() == 0) {
					// System.out.println(j);
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), form.format(80 - (listDetail.getGyro() / 10.0)));
					// System.out.println(map.toString());
				} else {
					// System.out.println(j);
					map.put(listDetail.getModule_id(), form.format(80 - (listDetail.getGyro() / 10.0)));
					// System.out.println(map.toString());
				}
			}
			result.add(map);
			// Collections.reverse(result);
		}
		Collections.reverse(result);
		return result;
	}
	
	@RequestMapping("/admin/DispatcherModuleRecent")
	private List<Map<String, Object>> dispatcherModuleRecent(@ModelAttribute TbEventVO event) throws Exception {
		
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		List<TbEventVO> list = new ArrayList<TbEventVO>();
		List<TbEventVO> innnerlist = new ArrayList<TbEventVO>();

//		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> innerMap = new HashMap<String, Object>();
		List<Object> innerList = new ArrayList<Object>();
		List<Map<String, Object>> listAll = new ArrayList<Map<String, Object>>();
		
//		for(int i = 0 ; i < moduleList.size() ; i ++) {
//			map = new HashMap<String, Object>();
//			map.put("module_id", String.valueOf(i));
//			list = new ArrayList<TbEventVO>();
//			list = eService.selectRecentToModule(String.valueOf(i));
//			System.out.println("===================");
//			System.out.println(list);
//			System.out.println("===================");
//			innnerlist = new ArrayList<TbEventVO>();
//			for(int j = 0; j < list.size(); j ++) {				
//				innerMap = new HashMap<String,Object>();
//				innerMap.put("module_id",list.get(j).getModule_id());
//				innerMap.put("time",list.get(j).getTime());
//				innerMap.put("temp",list.get(j).getTemp());
//				innerMap.put("smoke",list.get(j).getSmoke());
//				innerMap.put("gyro",list.get(j).getGyro());
//				innerList.add(innerMap);
//			}
//			
//			map.put("value", innerList);
//			
//			listAll.add(map);
//		}
//		
//		return listAll;
//		}
	
	for(int i = 0 ; i < moduleList.size() ; i ++) {
		map = new HashMap<String, Object>();
		map.put("module_id", String.valueOf(i));
		list = new ArrayList<TbEventVO>();
		list = eService.selectRecentToModule(String.valueOf(i));
		map.put("value", list);
		
		listAll.add(map);
	}
	return listAll;
	}
	
}
	
	// @RequestMapping("/DispatcherPart/{path}")
	// private List<Map<String,Object>> dispatcherPart(@PathVariable("path") String
	// path, @ModelAttribute TbEventVO event) throws Exception{
	// String typeArduino = "arduino";
	// List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
	// ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();
	//
	// List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
	// Map<String, Object> map = new HashMap<String, Object>();
	//
	// list = eService.dispatcherPart();
	//// System.out.println(list.size());
	// result = new ArrayList<Map<String,Object>>();
	//
	// for(int i = 0; i < moduleList.size(); i ++) {
	//// System.out.println(i);
	// map = new LinkedHashMap<String, Object>();
	// for(int j = i * moduleList.size() ; j < (i+1) * moduleList.size() ; j++) {
	// TbEventVO listDetail = list.get(j);
	//// map = new LinkedHashMap<String, Object>();
	//// System.out.println(j);
	// switch (path) {
	// case "temp":
	// if( j % moduleList.size() == 0) {
	//// System.out.println(j);
	// map.put("time", listDetail.getTime().substring(11,19));
	// map.put(listDetail.getModule_id(), listDetail.getTemp());
	//// System.out.println(map.toString());
	// }else {
	//// System.out.println(j);
	// map.put(listDetail.getModule_id(), listDetail.getTemp());
	//// System.out.println(map.toString());
	// }
	// case "smoke":
	// if( j % moduleList.size() == 0) {
	//// System.out.println(j);
	// map.put("time", listDetail.getTime().substring(11,19));
	// map.put(listDetail.getModule_id(), listDetail.getSmoke());
	//// System.out.println(map.toString());
	// }else {
	//// System.out.println(j);
	// map.put(listDetail.getModule_id(), listDetail.getSmoke());
	//// System.out.println(map.toString());
	// }
	// case "gyro":
	// if( j % moduleList.size() == 0) {
	//// System.out.println(j);
	// map.put("time", listDetail.getTime().substring(11,19));
	// map.put(listDetail.getModule_id(), listDetail.getGyro());
	//// System.out.println(map.toString());
	// }else {
	//// System.out.println(j);
	// map.put(listDetail.getModule_id(), listDetail.getGyro());
	//// System.out.println(map.toString());
	// }
	// case "fire":
	// if( j % moduleList.size() == 0) {
	//// System.out.println(j);
	// map.put("time", listDetail.getTime().substring(11,19));
	// map.put(listDetail.getModule_id(), listDetail.getFire());
	//// System.out.println(map.toString());
	// }else {
	//// System.out.println(j);
	// map.put(listDetail.getModule_id(), listDetail.getFire());
	//// System.out.println(map.toString());
	// }
	// default:
	// break;
	// }
	// }
	// result.add(map);
	//// Collections.reverse(result);
	// }
	// Collections.reverse(result);
	// return result;
	//
	// }
	
