package kpc.iot.smb.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.catalina.startup.Tomcat;

import com.google.gson.Gson;

import kpc.iot.smb.data.dao.ActionDAO;
import kpc.iot.smb.data.dao.EventDAO;
import kpc.iot.smb.data.vo.TbActionIdVO;
import kpc.iot.smb.data.vo.TbEventVO;
import kpc.iot.smb.fcm.Data;
import kpc.iot.smb.fcm.FCMData;
import kpc.iot.smb.util.Action;

public class EventInServlet extends Action{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String issue = request.getParameter("issue");
		String module_id = request.getParameter("module_id");
		String temp = request.getParameter("temp");
		String smoke = request.getParameter("smoke");
		String gyro = request.getParameter("gyro");
		String fire = request.getParameter("fire");
//		String reqContentType = request.getContentType();
		//ISSUE Process
		// 0 -> DB, 1 -> Rasp,DB, 2->Rasp,DB, 3->Rasp,DB,

		switch (issue) {
		case "1":
			System.out.println("화재경보");
//			System.out.println( "reqContentType : " + reqContentType );
			imageGet(issue);
			break;
		case "2":
			System.out.println("지진경보");
//			System.out.println( "reqContentType : " + reqContentType );
			imageGet(issue);
			break;
		case "3":
			System.out.println("지진 + 화재경보");
//			System.out.println( "reqContentType : " + reqContentType );
			imageGet(issue);
			break;
		default:
			EventDAO dao = new EventDAO();
			TbEventVO vo = new TbEventVO();
			vo.setModule_id(module_id);
			vo.setTemp(Float.parseFloat(temp));
			vo.setSmoke(Float.parseFloat(smoke));
			vo.setGyro(Float.parseFloat(gyro));
			vo.setFire(Float.parseFloat(fire));
			vo.setIssue(issue);
			dao.insertEvent(vo);
			System.out.println("InsertEvent Succes");
			request.setAttribute("issue", issue);
			request.setAttribute("sensorId", module_id);
			request.setAttribute("temp", temp);
			request.setAttribute("smoke", smoke);
			request.setAttribute("gyro", gyro);
			request.setAttribute("fire", fire);
			request.getRequestDispatcher("data1.jsp").forward(request, response);
			break;
		}
	}
	public void imageGet(String issue){
		String url;
		switch (issue) {
		case "1":
			try {
				url = "http://192.168.0.13:5001/cam/1";
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				InputStream input = con.getInputStream();
				System.out.println("\nSending 'POST' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
				transData(input);
				break;
			}catch (IOException e) {
				e.printStackTrace();
			}

		case "2":
			try {
				url = "http://192.168.0.13:5001/cam/2";
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				InputStream input = con.getInputStream();
				System.out.println("\nSending 'POST' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
				transData(input);
				break;
			}catch (IOException e) {
				e.printStackTrace();
			}
		case "3":
			try {
				url = "http://192.168.0.13:5001/cam/3";
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				InputStream input = con.getInputStream();
				System.out.println("\nSending 'POST' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
				transData(input);
				break;
			}catch (IOException e) {
				e.printStackTrace();
			}
		default:
			break;
		}
	}
	
	public void transData(InputStream input) {
		// data transform
		byte[] buffer = new byte[8 * 1024];
		try {
			Date date = new Date();
			SimpleDateFormat transFomat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String fileName = transFomat.format(date);
			String serverName = "C:\\workspace\\SaveForYou\\javadev\\SafeForYou\\WebContent\\img\\Event\\";
			String fileExtension = ".png";
			String serverIp = "http://192.168.0.35:8088/SafeForYou/img/Event/";
// http://192.168.0.35:8088/SafeForYou/img/Event/20180322_163657.png
			String DbName = serverName + fileName + fileExtension;

			OutputStream output = new FileOutputStream(DbName);
			try {
				int bytesRead;
				while ((bytesRead = input.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
				System.out.println("Transform 완료!");
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				output.close();
				ActionDAO dao = new ActionDAO();
				TbActionIdVO vo = new TbActionIdVO();
				vo.setUrl(serverIp + fileName +fileExtension);
				dao.insertPicture(vo);
				androidSend(serverIp + fileName +fileExtension);
				
			} 
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					input.close();
			} 	catch (IOException e) {
					e.printStackTrace();
			}
		} 	
	}
	
	public void androidSend(String fileName) {
		// TODO Auto-generated constructor stub
				String url = "https://fcm.googleapis.com/fcm/send"; 
				FCMData fcmData = new FCMData();
				Data data = new Data();
				data.setTitle("[I Save You]긴급상황 발생");
				data.setContent_1(fileName);
				data.setContent_2(fileName);
				fcmData.setData(data);
				fcmData.setTo("foSJVNORz8Y:APA91bEMxsYGGEEGlqnxPa3Gh3OB25evSPs5nR5yfbmxvEBbZvMn4aoo3L0Cn78bImFNVFSCEchn60Ii_-HQVjUapqkAeHeNo_roY4yUVeUgHIH2V20SaSdo3nFcQerbyrfjXPrxpImX");
				// DB에 전체 SELECT
			
				Gson gson = new Gson();
				String params = gson.toJson(fcmData);
				System.out.println(params);
				try {
					String returnData = sendPost(url, params);
					System.out.println(returnData);
				}catch(Exception e) {
					System.out.println("e : " + e);
				}		
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
