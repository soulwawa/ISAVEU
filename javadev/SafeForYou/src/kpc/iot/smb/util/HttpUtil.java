package kpc.iot.smb.util;

import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path){
		try{
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}catch(Exception ex){
			System.out.println("forward: " + ex);
			throw new RuntimeException("forward: " + ex);
		}
	} // redirect
	
	public static void redirect(HttpServletResponse response, String path){
		try{
			response.sendRedirect(path);
		}catch(Exception ex){
			System.out.println("redirect: " + ex);
			throw new RuntimeException("redirect: " + ex);
		}
	} // forward
	
	public static String encoding(String url){
		try{
			url = URLEncoder.encode(url, "UTF-8");
		}catch(Exception ex){
			System.out.println("URL : " + ex);
			throw new RuntimeException("URL : " + ex);			
		}
		return url;
	}
	
	public static void main(String args[]){
//		String str = "�ѱ� ���";
//		str = HttpUtil.encoding(str);
//		System.out.println(str);
	}
}
