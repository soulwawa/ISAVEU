package kpc.iot.smb.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kpc.iot.smb.fcm.Data;
import kpc.iot.smb.fcm.FCMData;
import kpc.iot.smb.util.Action;
import kr.or.kpc.test.TempDAO;
import kr.or.kpc.test.TempListVO;
import kr.or.kpc.test.TempVO;



public class TempInServlet extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
//		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String temp1 = request.getParameter("temp");
		double temp = toConvertTemp(temp1);
		String loc = request.getParameter("loc");
		System.out.println("type : "  + type);
		System.out.println("temp1 : "  + temp1);
		System.out.println("temp : "  + temp);
		System.out.println("loc : "  + loc);
		TempDAO dao = new TempDAO();
		TempVO vo = new TempVO();
		
		vo.setLoc(loc);
		vo.setType(type);
		vo.setTemperature(temp + "");
		dao.insertTemp(vo);
//		out.println("success");

		vo.setLoc(loc);
		ArrayList<TempVO> list = dao.getTempList(vo);
		TempListVO tList = new TempListVO();
		tList.setCnt(list.size());
		tList.setStatus("success");
		tList.setList(list);
		Gson gson = new Gson();
		String result = gson.toJson(tList);
		tList = gson.fromJson(result, TempListVO.class);
		response.setContentType("application/json;charset=utf-8");

		String msg = String.valueOf(temp);
		System.out.println("msg::::::" + msg);
		String url = "https://fcm.googleapis.com/fcm/send"; 
		FCMData fcmData = new FCMData();
		Data data = new Data();
		String imageEx = "http://192.168.0.35:8088/SafeForYou/main.png";
//		data.setContent("빠르게 대피해주세요!");
		data.setContent(imageEx);
//		data.setTitle("[I Save You]긴급상황 발생");
		data.setTitle(msg);
		fcmData.setData(data);
		fcmData.setTo("foSJVNORz8Y:APA91bEMxsYGGEEGlqnxPa3Gh3OB25evSPs5nR5yfbmxvEBbZvMn4aoo3L0Cn78bImFNVFSCEchn60Ii_-HQVjUapqkAeHeNo_roY4yUVeUgHIH2V20SaSdo3nFcQerbyrfjXPrxpImX");
		// DB에 전체 SELECT
	
		Gson gson2 = new Gson();
		String params = gson.toJson(fcmData);
		System.out.println(params);
		try {
			String returnData = sendPost(url, params);
			System.out.println(returnData);
		}catch(Exception e) {
			System.out.println("e : " + e);
		}
		
	}
	
	public double toConvertTemp(String reading){
		 float readData = Float.parseFloat(reading);
		 double voltage = readData * 5.0;
		 voltage /= 1024.0;
		 double temperatureC = (voltage - 0.5) * 100 ; 
		 return Math.round(temperatureC * 100d) / 100d;
	}
	
	public String sendPost(String url, String parameters) throws Exception { 
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
   
       URL obj = new URL(url);
       HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
   
       //reuqest header
       con.setRequestMethod("POST");
       con.setRequestProperty("Content-Type", "application/json");
       con.setRequestProperty("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
       String urlParameters = parameters;
   
       //post request
       con.setDoOutput(true);
       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
       wr.write(urlParameters.getBytes("UTF-8"));
       wr.flush();
       wr.close();

       int responseCode = con.getResponseCode();     
       System.out.println("Post parameters : " + urlParameters);
       System.out.println("Response Code : " + responseCode);
   
       StringBuffer response = new StringBuffer();
   
       if(responseCode == 200){   
              BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
              String inputLine;
              while ((inputLine = in.readLine()) != null) {
                     response.append(inputLine);
              }
              in.close();   
       }
       //result
       System.out.println(response.toString());
       return response.toString();
	}
	
	
	
}

