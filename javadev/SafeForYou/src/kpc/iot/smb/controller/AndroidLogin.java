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
	private String HR_PROFILE = "http://192.168.0.35:8088/SafeForYou/img/HR_profile/";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("u_id");
		String andPw = request.getParameter("u_pw");
		String fcmValue = request.getParameter("u_instancekey");
		String compareId;
		
		System.out.println(andId);
		System.out.println(andPw);
		System.out.println(fcmValue);
		
		TbHrVO vo = new TbHrVO();
		HrDAO dao = new HrDAO();
		FCMData fcmData = new FCMData();
		Data data = new Data();
		Gson gson = new Gson();
		
//		String dir =  http://192.168.0.35:8088/SafeForYou/img/HR_profile/0000000000.png
		vo.setId(andId);
		ArrayList<TbHrVO> list = dao.getHrList(vo);
//		System.out.println(list.size());
		if(list.size() == 0) {
			System.out.println("Query FAIL");
			
		}else {
			System.out.println("Query SUCCESS");
			TbHrVO result = list.get(0);
			if(andId.equals(result.getId()) && andPw.equals(result.getPw())) {
				System.out.println("GOOD");
				JsonObject loginOk = new JsonObject(); 
				loginOk.addProperty("access", "1");
				System.out.println(loginOk);
			}
			
		}
		
	
	}
	



}
