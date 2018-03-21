package kpc.iot.smb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		//ISSUE Process
		// 0 -> DB, 1 -> Rasp,DB, 2->Rasp,DB, 3->Rasp,DB,
		
		switch (issue) {
		case "1":
			System.out.println("화재경보");
			send();
			break;
		case "2":
			System.out.println("지진경보");
			send();
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
		String url = "http://192.168.0.13:5000/ledcon/1/1";
	
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
	    // optional default is GET
	    con.setRequestMethod("GET");
	
	    //add request header 헤더를 만들어주는것.
	    con.setRequestProperty("User-Agent", "Chrome/version");
	    con.setRequestProperty("Accept-Charset", "UTF-8");
	    con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
	    int responseCode = con.getResponseCode();
	    System.out.println("\nSending 'GET' request to URL : " + url);
	    System.out.println("Response Code : " + responseCode);
	
	    BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	
	    while ((inputLine = in.readLine()) != null) {
	        response.append(inputLine);
	    }
	    in.close();
	
	    //print result
	    System.out.println(response.toString());
	}
}
	