package kpc.iot.smb.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpc.iot.smb.data.dao.EventDAO;
import kpc.iot.smb.data.vo.TbEventVO;
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
		String reqContentType = request.getContentType();
		
		//ISSUE Process
		// 0 -> DB, 1 -> Rasp,DB, 2->Rasp,DB, 3->Rasp,DB,
		
		switch (issue) {
		case "1":
			System.out.println("화재경보");
//			String reqContentType = request.getContentType();
			System.out.println( "reqContentType : " + reqContentType );
			String url = "http://192.168.0.13:5001/event/1";
		    URL obj = new URL(url);
		    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		    // optional default is GET
		    con.setRequestMethod("GET");
		    int responseCode = con.getResponseCode();
		    System.out.println("\nSending 'POST' request to URL : " + url);
		    System.out.println("Response Code : " + responseCode);
//		    System.out.println(request.getInputStream().toString());
		    byte[] buffer = new byte[8 * 1024];

//		    InputStream input = request.getInputStream();
		    InputStream input = con.getInputStream();
//		    System.out.println(con.getContentLength());
//		    System.out.println(con.getInputStream());
		    try {
		      OutputStream output = new FileOutputStream("C:\\workspace\\SaveForYou\\javadev\\SafeForYou\\WebContent\\img\\2.png");
		      try {
		        int bytesRead;
		        while ((bytesRead = input.read(buffer)) != -1) {
		          output.write(buffer, 0, bytesRead);
		        }
		        System.out.println("Transform 완료!");
		      }catch (Exception e) {
				System.out.println("e1:" + e);
			
		      }finally {
		        output.close();
		      } 
		    }catch (Exception e) {
		    	System.out.println("e2:" + e);
				
		      
		    } finally {
		      input.close();
		    }
		    
		    
			break;
		case "2":
			System.out.println("지진경보");
			break;
		case "3":
			System.out.println("지진 + 화재경보");
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
			break;
		}
	}
	public void send() throws IOException {
		String url = "http://192.168.0.13:5000/event/1";
	
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
	    // optional default is GET
	    con.setRequestMethod("GET");
	
	    //add request header 헤더를 만들어주는것.
//	    con.setRequestProperty("User-Agent", "Chrome/version");
//	    con.setRequestProperty("Accept-Charset", "UTF-8");
//	    con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
	    int responseCode = con.getResponseCode();
	    System.out.println("\nSending 'GET' request to URL : " + url);
	    System.out.println("Response Code : " + responseCode);
	

//	    in.close();
	
	    //print result
//	    System.out.println(response.toString());
	}
	
}
	