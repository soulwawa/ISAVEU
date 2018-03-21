package kpc.iot.smb.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
			String reqContentType = request.getContentType();
			System.out.println( "reqContentType : " + reqContentType );
			InputStream input = request.getInputStream();
			ByteArrayOutputStream result = null;
			PrintWriter writer = null;
			try {
				input = request.getInputStream();
				System.out.println(input.equals(null));
				result = new ByteArrayOutputStream();
				
				byte[] buffer = new byte[1024];
				int size = 0;
				 while((size=input.read(buffer, 0, 1024))!=-1){
					    //-1 이 EOF

					    System.out.println("size : " + size);
					    result.write( buffer, 0, size );
					   }
				File dir = new File("C:\\workspace\\SaveForYou\\javadev\\SafeForYou\\WebContent\\img");
				if(!dir.exists()) {
					dir.mkdir();
				}
				File file = new File("C:\\workspace\\SaveForYou\\javadev\\SafeForYou\\WebContent\\img\\image.png");
				if(!file.exists()) {
					file.createNewFile();
				}
				writer = new PrintWriter(file);
				writer.println(result.toString("UTF-8"));
				writer.close();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				try {
					if(input!=null) {
						
						 input.close();
				    }
				   } catch ( Exception e ) {
				    input = null;
				   }
				   
				   try {
				    if ( result != null ) {
				     result.close();
				    }
				   } catch ( Exception e ) {
				    result = null;
				   }
				   
				   try {
				    if ( writer != null ) {
				     writer.close();
				    }
				   } catch ( Exception e ) {
				    writer = null;
				   }
				  }
			
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
		String url = "http://192.168.0.13:5000/event/1";
	
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
	