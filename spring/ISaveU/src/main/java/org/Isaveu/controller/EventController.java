package org.Isaveu.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.Isaveu.domain.LocationByIssueVO;
import org.Isaveu.domain.ModuleByLocationVO;
import org.Isaveu.domain.TbActionVO;
import org.Isaveu.domain.TbEventVO;
import org.Isaveu.domain.TbHrVO;
import org.Isaveu.domain.TbModuleVO;
import org.Isaveu.fcm.Data;
import org.Isaveu.fcm.FCMData;
import org.Isaveu.service.ActionService;
import org.Isaveu.service.EventService;
import org.Isaveu.service.HrService;
import org.Isaveu.service.LocationService;
import org.Isaveu.service.ModuleService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@RestController
public class EventController {
	String issue;
	String issueTemp = "0";
	float temp;
	float smoke;
	float gyro;
	float fire;
	String module_id;
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
	ModuleService mService;

	@RequestMapping(value = "/module/eventIn.do", method = RequestMethod.GET)
	private String eventIn(@ModelAttribute TbEventVO event,
			@RequestParam(value = "reset", defaultValue = "0") String reset) throws Exception {
		issue = event.getIssue();
		temp = event.getTemp();
		smoke = event.getSmoke();
		gyro = event.getGyro();
		fire = event.getFire();
		module_id = event.getModule_id();

		// if 모듈이 여러개일때 가정
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);

		// reset value "1" 이면 issueTemp 를 초기화
		issueTemp = reset.equals("1") ? "0" : issueTemp;
		Date date = new Date();
		SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String datenow = transFomat.format(date);
		
		switch (issue) {
		case "1":
			System.out.println("화재경보 < " + datenow + " >" );
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("DB : Insert Sensing Succes");
			issueTemp = issue;
			RaspControl(issue);
			break;
		case "2":
			System.out.println("지진경보 < " + datenow + " >" );
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("DB : Insert Sensing Succes");
			issueTemp = issue;
			RaspControl(issue);
			break;
		case "3":
			System.out.println("지진 + 화재경보 < " + datenow + " >" );
			imageGet(issue);
			eService.insertEvent(event);
			System.out.println("DB : Insert Sensing Succes");
			issueTemp = issue;
			RaspControl(issue);
			break;
		default:
			RaspControl(issue);
			if (issueTemp == "4") {
				System.out.println("module : " + module_id + " 번 문제 발생 < " + datenow + " >" );
				fCMSendToAdmin(module_id);
				break;
			} else {
				if (issue.equals(issueTemp)) {
					issueTemp = issue;
//					System.out.println("module_id: " + module_id);
//					System.out.println("issue: " + issue + " / issueTemp: " + issueTemp);
					for (int i = 0; i < moduleList.size(); i++) {
						float ramdom = (float) Math.random();
						event.setModule_id(String.valueOf(i));
						event.setTemp(temp + ramdom);
						event.setSmoke(smoke + ramdom);
						event.setGyro(gyro + ramdom);
						event.setFire(fire + ramdom);
						event.setIssue(issue);
						eService.insertEvent(event);
						System.out.println("Sensor Status Check : " + event.getModule_id() + " : " + datenow);
						System.out.println("DB : Insert Sensing Succes");
					}
				} else {
					System.out.println("Sensor ERROR :" + module_id);
					fCMSendToAdmin(module_id);
					issueTemp = "4";
					break;
				}

			}
		}
		return "200".toString();
	}

	public void imageGet(String issue) {
		Date date = new Date();
		SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String datenow = transFomat.format(date);
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("http://192.168.0.13:5001/cam/" + issue).build().toUri();
		byte[] response = new byte[8 * 1024];
		response = restTemplate.getForObject(uri, byte[].class);
		String localName = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\";
		String fileExtension = ".png";
		String androidPass = "http://192.168.0.35:9999/Android/IamgeGet.do?imageID=";
		String serverName = localName + datenow + fileExtension;
		File imageFile = new File(serverName);
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile));
			os.write(response);
			os.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			TbActionVO action = new TbActionVO();
			action.setUrl(serverName);
			action.setModule_id(module_id);
			FcmSend(androidPass + datenow + fileExtension, issue);
			try {
				aService.insertAction(action);
				System.out.println("SERVER - > Raspberry Request");
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
		// RaspControl(issue);
	}

	public void fCMSendToAdmin(String module_id) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		// TITILE
		ArrayList<ModuleByLocationVO> localList = new ArrayList<ModuleByLocationVO>();
		try {
			localList = lService.moduleByLocation(module_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModuleByLocationVO location = localList.get(0);
		String title = location.getLocation() + "/" + location.getDept_name();

		// DATA
		headers.add("Authorization",
				"key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
		ArrayList<TbHrVO> hrList = new ArrayList<TbHrVO>();
		try {
			// 관리자 Level이 "0"인 사람만
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
		data.setContent_1("module_id: " + module_id + " 장비 확인(센서값 오류 이상)");
		 data.setContent_2("5"); // 장비 확인 임시지정
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);

		String params = gson.toJson(fcmData);
		System.out.println(params);

		HttpEntity request;
		request = new HttpEntity(params, headers);
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
		System.out.println(result.getBody());
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
		System.out.println("Request /admin/Dispatcher");
		Date date = new Date();
		SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String datenow = transFomat.format(date);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", form.format(temp));
		map.put("smoke", form.format((smoke / 20.0)));
		map.put("fire", form.format(80 - (fire / 13.0)));
		map.put("gyro", form.format(80 - (gyro / 13.0)));
		map.put("date", datenow);
		map.put("issue", issue);
		return map;
	}

	@RequestMapping("/admin/DispatcherRecent")
	private List<Map<String, Object>> dispatcherRecent(@ModelAttribute TbEventVO event, @RequestParam("num") int num)
			throws Exception {
		System.out.println("Request /admin/DispatcherRecent");
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();
		list = eService.selectRecent(num);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			map.put("time", list.get(i).getTime().substring(11, 19));
			map.put("temp", list.get(i).getTemp());
			map.put("smoke", list.get(i).getSmoke());
			map.put("fire", list.get(i).getFire());
			map.put("gyro", list.get(i).getGyro());
			myList.add(i, map);
		}
		Collections.reverse(myList);
		return myList;
	}

	@RequestMapping("/admin/DispatcherPart/temp")
	private List<Map<String, Object>> dispatcherPartTemp(@ModelAttribute TbEventVO event) throws Exception {
		System.out.println("Request /admin/DispatcherPart/temp");
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());

		for (int i = 0; i < moduleList.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				if (j % moduleList.size() == 0) {
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), form.format(listDetail.getTemp()));
				} else {
					map.put(listDetail.getModule_id(), form.format(listDetail.getTemp()));
				}
			}
			result.add(map);
		}
//		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/smoke")
	private List<Map<String, Object>> dispatcherPartSmoke(@ModelAttribute TbEventVO event) throws Exception {
		System.out.println("Request /admin/DispatcherPart/smoke");
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());

		for (int i = 0; i < moduleList.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				if (j % moduleList.size() == 0) {
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), listDetail.getSmoke());
				} else {
					map.put(listDetail.getModule_id(), listDetail.getSmoke());
				}
			}
			result.add(map);
		}
		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/fire")
	private List<Map<String, Object>> dispatcherPartFire(@ModelAttribute TbEventVO event) throws Exception {
		System.out.println("Request /admin/DispatcherPart/fire");
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());

		for (int i = 0; i < moduleList.size(); i++) {
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				if (j % moduleList.size() == 0) {
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), listDetail.getFire());
				} else {
					map.put(listDetail.getModule_id(), listDetail.getFire());
				}
			}
			result.add(map);
		}
		Collections.reverse(result);
		return result;

	}

	@RequestMapping("/admin/DispatcherPart/gyro")
	private List<Map<String, Object>> dispatcherPartGyro(@ModelAttribute TbEventVO event) throws Exception {
		System.out.println("Request /admin/DispatcherPart/gyro");
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		ArrayList<TbEventVO> list = new ArrayList<TbEventVO>();

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		list = eService.dispatcherPart(moduleList.size() * moduleList.size());
		// System.out.println(list.size());
		// result = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			// System.out.println(i);
			map = new LinkedHashMap<String, Object>();
			for (int j = i * moduleList.size(); j < (i + 1) * moduleList.size(); j++) {
				TbEventVO listDetail = list.get(j);
				if (j % moduleList.size() == 0) {
					map.put("time", listDetail.getTime().substring(11, 19));
					map.put(listDetail.getModule_id(), listDetail.getGyro());
				} else {
					map.put(listDetail.getModule_id(), listDetail.getGyro());
				}
			}
			result.add(map);
		}
		Collections.reverse(result);
		return result;
	}

	@RequestMapping("/admin/DispatcherModuleRecent")
	private List<Map<String, Object>> dispatcherModuleRecent(@ModelAttribute TbEventVO event) throws Exception {
		System.out.println("Request /admin/DispatcherModuleRecent");
		List<TbModuleVO> moduleList = mService.getModuleList(typeArduino);
		List<TbEventVO> list = new ArrayList<TbEventVO>();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> listAll = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < moduleList.size(); i++) {
			map = new HashMap<String, Object>();
			map.put("module_id", String.valueOf(i));
			list = new ArrayList<TbEventVO>();
			list = eService.selectRecentToModule(String.valueOf(i));
			Collections.reverse(list);
			map.put("value", list);

			listAll.add(map);
		}
//		Collections.reverse(listAll);
		return listAll;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/DisasterCheck.do")
	public Map<String, Object> AndroiDisasterCheck(@RequestParam("loc") String loc){
		System.out.println("Request /admin/DisasterCheck.do");
		Map<String, Object> map = new HashMap<String, Object>();
		String count = "";
		try {
			count = lService.locationCount(loc);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<LocationByIssueVO> list = new ArrayList<LocationByIssueVO>();
		
		int countInt = Integer.parseInt(count);
		try {
			list = new ArrayList<LocationByIssueVO>();
			for (int i = 0; i < countInt; i++) {
				list.addAll(lService.AndroidDisasterCheck(String.valueOf(i)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("floor", loc);
		map.put("list", list);
		System.out.println(map);
		return map;
		
	}

}

// swich case문
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
