package kpc.iot.smb.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kpc.iot.smb.data.dao.HrDAO;
import kpc.iot.smb.data.vo.TbHrVO;
import kpc.iot.smb.fcm.Data;
import kpc.iot.smb.fcm.FCMData;
import kpc.iot.smb.util.Action;


public class AndroidLogin extends Action{
//	private String HR_PROFILE = "http://192.168.0.35:8088/SafeForYou/img/HR_profile/";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("u_id");
		String andPw = request.getParameter("u_pw");
		String fcmValue = request.getParameter("u_instancekey");
		
//		System.out.println(andId);
//		System.out.println(andPw);
//		System.out.println(fcmValue);
		
		TbHrVO vo = new TbHrVO();
		HrDAO dao = new HrDAO();
		
		vo.setId(andId);
		ArrayList<TbHrVO> list = dao.getHrList(vo);
		JsonObject loginOk = new JsonObject();
		
		if(list.size() == 0) { 
			System.out.println("Android Login Query FAIL");
			loginOk.addProperty("access", "0");
			loginOk.addProperty("name", "0");
			loginOk.addProperty("profile", "0");
			loginOk.addProperty("email", "0");
			String resultJson = loginOk.toString();
			request.setAttribute("resultJson", resultJson);
			request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
		}else {
			TbHrVO result = list.get(0);
			System.out.println("Android Login Query SUCCESS");
			if(andId.equals(result.getId()) && andPw.equals(result.getPw())) {
				if(!(fcmValue.equals(result.getFcm()))) {
					System.out.println("FCM UPDATE");
					vo.setFcm(fcmValue);
					vo.setId(andId);
					dao.updateFcm(vo);
				}else {
					System.out.println("FCM EQUALS");
					loginOk.addProperty("access", "1");
					loginOk.addProperty("name", result.getName().toString());				
					loginOk.addProperty("profile", result.getProfile().toString());
					loginOk.addProperty("email", result.getEmail().toString());
					loginOk.addProperty("fcm", result.getFcm().toString());
					String resultJson = loginOk.toString();
					request.setAttribute("resultJson", resultJson);
					request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
				}
			}else {
				System.out.println("Login FAIL");
				loginOk.addProperty("access", "0");
				loginOk.addProperty("name", "0");
				loginOk.addProperty("profile", "0");
				loginOk.addProperty("email", "0");
				String resultJson = loginOk.toString();
				request.setAttribute("resultJson", resultJson);
				request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
			}
		}
	}


}
