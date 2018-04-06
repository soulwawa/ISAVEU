package kr.or.kpc.test;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.FontUIResource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kpc.iot.smb.data.dao.HrDAO;
import kpc.iot.smb.data.vo.TbHrVO;
import kpc.iot.smb.fcm.Data;
import kpc.iot.smb.fcm.FCMData;
import kpc.iot.smb.fcm.FCMDataTo;

public class atest {

	public static void main(String[] args) {
		
		ArrayList<TbHrVO> arrayList = new ArrayList<TbHrVO>();
		TbHrVO vo = new TbHrVO();
		HrDAO dao = new HrDAO();
		arrayList = dao.getHrListAll();
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
		data.setContent_1(url);
		fcmData.setData(data);
		fcmData.setRegistration_ids(reglist);
		
		String params = gson.toJson(fcmData);
		
		System.out.println(params);
		
		
		
		
		
		
		
//		ArrayList<String> fcm = fcmdata.getRegistration_ids();
//		for (String string : fcm) {
//			System.out.println(string);
//		}
		

//		arrayList.add("\"+ + \"");
//
//		arrayList.add("Test2");
//
//		arrayList.add("Test3");

//		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
//			TbHrVO tbHrVO = (TbHrVO) iterator.next();
//			
//			System.out.println(tbHrVO.getFcm());
//		}
//		for (TbHrVO tbHrVO : arrayList) {
//			System.out.println(tbHrVO.getFcm());
//		}


//		String[] array = arrayList.toArray(new String[arrayList.size()]);
		


		
	}

}
